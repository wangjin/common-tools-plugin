package com.github.wangjin252.commontools.action;

import com.github.wangjin252.commontools.ui.DBSettingsForm;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.DialogBuilder;
import com.intellij.openapi.ui.DialogWrapper;

public class CodeGeneratorAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        DialogBuilder dialogBuilder = new DialogBuilder(e.getProject());
        dialogBuilder.setTitle("数据库设置");
        dialogBuilder.getDialogWrapper().setResizable(false);
        DBSettingsForm dbSettingsForm = new DBSettingsForm();
        dialogBuilder.setCenterPanel(dbSettingsForm);
        dialogBuilder.addOkAction().setText("确定");
        dialogBuilder.setOkOperation(() -> {






            // 关闭当前窗体
            dialogBuilder.getDialogWrapper().close(DialogWrapper.OK_EXIT_CODE);

        });
        dialogBuilder.show();

    }
}
