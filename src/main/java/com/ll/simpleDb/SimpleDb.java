package com.ll.simpleDb;

import java.sql.*;

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

    public void run(String sql, Object... args) {
        System.out.println("== rawSql ==");
        System.out.println(sql);
        System.out.println();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            // 쿼리 실행
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
