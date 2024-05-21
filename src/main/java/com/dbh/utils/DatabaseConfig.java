package com.dbh.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.dbh.utils.AppConstant.*;

public class DatabaseConfig {

    public static Connection getconnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not Connected.");
        }
        return connection;
    }

    public static void main(String[] args) {
        DatabaseConfig.getconnection();
    }
}