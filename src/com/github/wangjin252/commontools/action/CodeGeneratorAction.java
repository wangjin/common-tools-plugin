package com.github.wangjin252.commontools.action;

import com.github.wangjin252.commontools.entity.DBInfo;
import com.github.wangjin252.commontools.ui.CodeGeneratorForm;
import com.github.wangjin252.commontools.ui.DBSettingsForm;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.DialogBuilder;
import com.intellij.openapi.ui.DialogWrapper;

public class CodeGeneratorAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {


        DialogBuilder dbDialogBuilder = new DialogBuilder(e.getProject());
        dbDialogBuilder.setTitle("数据库设置");
        dbDialogBuilder.getDialogWrapper().setResizable(false);
        DBSettingsForm dbSettingsForm = new DBSettingsForm();
        dbDialogBuilder.setCenterPanel(dbSettingsForm);
        dbDialogBuilder.addOkAction().setText("确定");
        dbDialogBuilder.setOkOperation(() -> {

            DBInfo dbInfo = dbSettingsForm.getInputDBInfo();

            // 关闭当前窗体
            dbDialogBuilder.getDialogWrapper().close(DialogWrapper.OK_EXIT_CODE);


            DialogBuilder codeGeneratorDialogBuilder = new DialogBuilder(e.getProject());
            codeGeneratorDialogBuilder.setTitle("代码生成");
            codeGeneratorDialogBuilder.getDialogWrapper().setResizable(false);
            codeGeneratorDialogBuilder.setCenterPanel(new CodeGeneratorForm());
            codeGeneratorDialogBuilder.show();

        });
        dbDialogBuilder.show();

    }
}
