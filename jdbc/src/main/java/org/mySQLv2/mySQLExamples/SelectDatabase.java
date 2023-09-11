package org.mySQLv2.mySQLExamples;

import org.mySQLv2.TestApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SelectDatabase {

    public static void main(String[] args) {
        System.out.println("Connecting to a selected database...");
        // Open a connection
        try (Connection conn = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + "STUDENTS", TestApplication.USERNAME,
                TestApplication.PASSWORD)) {
            System.out.println("Connected database successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
