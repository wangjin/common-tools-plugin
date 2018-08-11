package com.github.wangjin252.commontools;

import com.github.wangjin252.commontools.service.GenerateService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CodeGeneratorAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        VirtualFile virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);

        if (virtualFile != null) {

            // domain包路径
            VirtualFile domain = virtualFile.getParent();
            // 根包路径
            String packagePath = domain.getParent().getCanonicalPath();
            BufferedReader bufferedReader = null;

            try {

                // 读取首行
                bufferedReader = new BufferedReader(new FileReader(new File(virtualFile.getCanonicalPath())));
                String firstLine = bufferedReader.readLine();
                String basePackage = null;
                if (firstLine.startsWith("package")) {
                    basePackage = firstLine.substring(0, firstLine.lastIndexOf(".")).replaceAll("package", "").trim();
                }

                GenerateService generateService = new GenerateService(packagePath, basePackage, virtualFile.getName().substring(0, virtualFile.getName().indexOf(".")));
                generateService.generate("domain","repository");
                generateService.generate("web","controller");
                generateService.generate("service","service");


                // 创建文件后刷新
                e.getData(PlatformDataKeys.PROJECT).getBaseDir().refresh(false, true);
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }


        }

    }
}
