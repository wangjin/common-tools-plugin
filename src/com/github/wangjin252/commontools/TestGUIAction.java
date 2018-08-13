package com.github.wangjin252.commontools;

import com.github.wangjin252.commontools.ui.GeneratorForm;
import com.github.wangjin252.commontools.ui.TestForm;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;

public class TestGUIAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        SwingUtilities.invokeLater(() -> {
           new GeneratorForm();
        });
    }
}
