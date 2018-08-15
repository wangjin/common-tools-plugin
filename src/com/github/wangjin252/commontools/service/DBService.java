package com.github.wangjin252.commontools.service;

import com.github.wangjin252.commontools.entity.Column;
import com.github.wangjin252.commontools.entity.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {


    public static Connection getConnection(String ip, int port, String dbName, String userName, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = String.format("jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=UTF-8&useSSL=false&connectTimeout=60000&socketTimeout=60000&autoReconnect=true&autoReconnectForPools=true&failOverReadOnly=false", ip, port, dbName);
        return DriverManager.getConnection(url, userName, password);
    }

    public static List<Table> getTables(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        // 获取表结果集
        ResultSet tableResultSet = metaData.getTables(null, "%", "%", null);

        List<Table> tables = new ArrayList<>();
        while (tableResultSet.next()) {
            Table table = new Table();
            table.setName(tableResultSet.getString("TABLE_NAME"));
            table.setColumns(getColumns(metaData, table.getName()));

            tables.add(table);
        }

        return tables;
    }

    private static List<Column> getColumns(DatabaseMetaData metaData, String tableName) throws SQLException {
        List<Column> columns = new ArrayList<>();
        ResultSet resultSet = metaData.getColumns(null, "%", tableName, "%");
        while (resultSet.next()) {
            Column column = new Column();
            column.setName(resultSet.getString("COLUMN_NAME"));
            column.setType(resultSet.getString("TYPE_NAME"));
            columns.add(column);
        }
        return columns;
    }


    public static void close(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}
