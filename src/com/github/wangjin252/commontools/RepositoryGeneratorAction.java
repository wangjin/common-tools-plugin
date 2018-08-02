package com.github.wangjin252.commontools;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.*;

public class RepositoryGeneratorAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        VirtualFile virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);

        // 当前选中文件的真实路径
        String currnetFilePath;
        if (virtualFile != null && (currnetFilePath = virtualFile.getCanonicalPath()) != null) {
            // 文件所在目录
            String parentPath = virtualFile.getParent().getCanonicalPath();
            BufferedReader bufferedReader = null;
            PrintStream printStream = null;
            String name = virtualFile.getName();
            if (name.contains(".java")) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(new File(currnetFilePath)));
                    // 读取首行包名
                    String packageName = bufferedReader.readLine();


                    String repositoryFileName = name.substring(0, name.indexOf(".")) + "Repository";

                    File file = new File(parentPath + File.separator + repositoryFileName + ".java");
                    printStream = new PrintStream(new FileOutputStream(file));
                    printStream.append(packageName);
                    printStream.println();
                    printStream.append("import org.springframework.stereotype.Repository;");
                    printStream.println();
                    printStream.append("import org.springframework.data.jpa.repository.JpaRepository;");
                    printStream.println();
                    printStream.append("@Repository");
                    printStream.println();
                    printStream.append("public interface ").append(repositoryFileName).append(" extends JpaRepository<").append(name.substring(0, name.indexOf("."))).append(", Integer> {");
                    printStream.println();
                    printStream.println();
                    printStream.append("}");


                } catch (IOException e1) {
                    e1.printStackTrace();
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }

                    if (printStream != null) {
                        printStream.close();
                    }
                }

            }
        }


    }
}
