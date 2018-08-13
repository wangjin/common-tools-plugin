package com.github.wangjin252.commontools.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {


    public static Connection getConnection(String ip, int port, String dbName, String userName, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = String.format("jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=UTF-8&useSSL=false&connectTimeout=60000&socketTimeout=60000&autoReconnect=true&autoReconnectForPools=true&failOverReadOnly=false", ip, port, dbName);
        return DriverManager.getConnection(url, userName, password);
    }
}
