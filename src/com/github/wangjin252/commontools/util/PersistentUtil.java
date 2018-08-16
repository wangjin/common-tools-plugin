package com.github.wangjin252.commontools.util;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.project.Project;

public class PersistentUtil {

    private Project project;

    public PersistentUtil(Project project) {
        this.project = project;
    }

    public void setDBSettings(String ip, int port, String dbName, String userName, String password) {
        PropertiesComponent instance = PropertiesComponent.getInstance(project);
        instance.setValue("ip", ip);
        instance.setValue("port", String.valueOf(port));
        instance.setValue("dbName", dbName);
        instance.setValue("userName", userName);
        instance.setValue("password", password);
    }

    public String[] getDBSettings(){
        String[] settings = new String[5];
        PropertiesComponent instance = PropertiesComponent.getInstance(project);
        settings[0] = instance.getValue("ip");
        settings[1] = instance.getValue("port");
        settings[2] = instance.getValue("dbName");
        settings[3] = instance.getValue("userName");
        settings[4] = instance.getValue("password");

        return settings;
    }
}
