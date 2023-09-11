package org.mySQLv2.mySQLExamples;

import org.mySQLv2.TestApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropDatabase {

    public static void main(String[] args) {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + "STUDENTS", TestApplication.USERNAME,
                TestApplication.PASSWORD); Statement stmt = conn.createStatement()) {
            String sql = "DROP DATABASE STUDENTS";
            stmt.executeUpdate(sql);
            System.out.println("Database dropped successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
