package com.lyl.serve.mybatis;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2022/3/17 21:55
 */
public class MyDataSource {
    public static void main(String[] args) throws SQLException {
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        pgSimpleDataSource.setServerNames(new String[]{"localhost"});
        pgSimpleDataSource.setPortNumbers(new int[]{5432});
        pgSimpleDataSource.setDatabaseName("test");
        pgSimpleDataSource.setCurrentSchema("public");
        pgSimpleDataSource.setUser("postgres");
        pgSimpleDataSource.setPassword("postgres");

        Connection conn = null;
        try {
            conn = pgSimpleDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Connection conn2 = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test?currentSchema=public","postgres","postgres");
        Properties properties = new Properties();
        properties.put("user","postgres");
        properties.put("password","postgres");
        Connection conn2 = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test?currentSchema=public",properties);

        // "dev", "dev");

        ResultSet resultSet = null;
        try {
            resultSet = conn2.createStatement().executeQuery("select * from idps_role");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

    }
}
