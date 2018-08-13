package com.github.wangjin252.commontools;

import com.github.wangjin252.commontools.entity.Pom;
import com.github.wangjin252.commontools.service.PomService;
import com.github.wangjin252.commontools.ui.GeneratorForm;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.vfs.VirtualFile;

import javax.swing.*;

public class TestGUIAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        SwingUtilities.invokeLater(() -> {

            VirtualFile baseDir = e.getData(PlatformDataKeys.PROJECT).getBaseDir();
            try {

                Pom pom = PomService.parse(baseDir.getCanonicalPath());
                new GeneratorForm(pom);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        });
    }
}
