package com.github.wangjin252.commontools.util;

import com.github.wangjin252.commontools.entity.DBInfo;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.project.Project;

public class PersistentUtil {

    private Project project;

    public PersistentUtil(Project project) {
        this.project = project;
    }

    public void setDBSettings(String ip, String port, String dbName, String userName, String password) {
        PropertiesComponent instance = PropertiesComponent.getInstance(project);
        instance.setValue("ip", ip);
        instance.setValue("port", port);
        instance.setValue("dbName", dbName);
        instance.setValue("userName", userName);
        instance.setValue("password", password);
    }

    public void setDBSettings(DBInfo dbInfo) {
        this.setDBSettings(dbInfo.getIp(), dbInfo.getPort(), dbInfo.getDbName(), dbInfo.getUserName(), dbInfo.getPassword());
    }

    public DBInfo getDBSettings() {
        DBInfo dbInfo = new DBInfo();
        PropertiesComponent instance = PropertiesComponent.getInstance(project);
        dbInfo.setIp(instance.getValue("ip"));
        dbInfo.setPort(instance.getValue("port"));
        dbInfo.setDbName(instance.getValue("dbName"));
        dbInfo.setUserName(instance.getValue("userName"));
        dbInfo.setPassword(instance.getValue("password"));

        return dbInfo;
    }
}
