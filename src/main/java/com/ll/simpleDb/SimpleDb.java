package com.ll.simpleDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleDb {
    private final Connection connection;

    public SimpleDb(String host, String username, String password, String dbName) {
        int port = 3306;

        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName
                + "?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeBehavior=convertToNull";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDevMode(boolean mode) {
    }
}
