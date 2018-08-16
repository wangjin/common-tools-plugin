package com.github.wangjin252.commontools.action;

import com.github.wangjin252.commontools.entity.DBInfo;
import com.github.wangjin252.commontools.entity.Table;
import com.github.wangjin252.commontools.service.GenerateService;
import com.github.wangjin252.commontools.ui.CodeGeneratorForm;
import com.github.wangjin252.commontools.ui.DBSettingsForm;
import com.github.wangjin252.commontools.util.DBUtil;
import com.github.wangjin252.commontools.util.PersistentUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogBuilder;
import com.intellij.openapi.ui.DialogWrapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CodeGeneratorAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        PersistentUtil persistentUtil = new PersistentUtil(e.getProject());

        DialogBuilder dbDialogBuilder = new DialogBuilder(e.getProject());
        dbDialogBuilder.setTitle("数据库设置");
        dbDialogBuilder.getDialogWrapper().setResizable(false);
        DBSettingsForm dbSettingsForm = new DBSettingsForm();

        // 根据存储初始化数据库信息
        dbSettingsForm.initValues(persistentUtil.getDBSettings());

        dbDialogBuilder.setCenterPanel(dbSettingsForm);
        dbDialogBuilder.addOkAction().setText("确定");
        dbDialogBuilder.setOkOperation(() -> {

            List<Table> tables = null;
            if ((tables = processDB(persistentUtil, dbSettingsForm)) != null) {
                // 关闭当前窗体
                dbDialogBuilder.getDialogWrapper().close(DialogWrapper.OK_EXIT_CODE);

                // 打开代码生成窗口
                showGeneratorDialog(e.getProject(), tables);
            }
        });
        dbDialogBuilder.show();

    }

    private List<Table> processDB(PersistentUtil persistentUtil, DBSettingsForm dbSettingsForm) {
        DBInfo dbInfo = dbSettingsForm.getInputDBInfo();
        persistentUtil.setDBSettings(dbInfo);

        Connection connection = null;
        try {
            connection = DBUtil.getConnection(dbInfo);
            return DBUtil.getTables(connection);


        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    DBUtil.close(connection);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }

        return null;
    }

    private void showGeneratorDialog(Project project, List<Table> tables) {
        DialogBuilder codeGeneratorDialogBuilder = new DialogBuilder(project);


        CodeGeneratorForm codeGeneratorForm = new CodeGeneratorForm();
        codeGeneratorForm.initBasePackage(project.getBasePath());
        codeGeneratorForm.initTable(tables);

        codeGeneratorDialogBuilder.setTitle("代码生成");
        codeGeneratorDialogBuilder.getDialogWrapper().setResizable(false);
        codeGeneratorDialogBuilder.setCenterPanel(codeGeneratorForm);
        codeGeneratorDialogBuilder.addOkAction().setText("生成");
        codeGeneratorDialogBuilder.setOkOperation(() -> {

            GenerateService generateService = new GenerateService();
            try {
                generateService.generate(project.getBasePath(), codeGeneratorForm.getPackageInfo(), tables);
            } catch (Exception e) {
                e.printStackTrace();
            }

            project.getBaseDir().refresh(true, true);
            // 关闭当前窗体
            codeGeneratorDialogBuilder.getDialogWrapper().close(DialogWrapper.OK_EXIT_CODE);
        });


        codeGeneratorDialogBuilder.show();


    }
}
