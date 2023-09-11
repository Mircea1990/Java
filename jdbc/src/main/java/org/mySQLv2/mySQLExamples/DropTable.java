package org.mySQLv2.mySQLExamples;

import org.mySQLv2.TestApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable {

    public static void main(String[] args) {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME, TestApplication.USERNAME,
                TestApplication.PASSWORD); Statement stmt = conn.createStatement()) {
            String sql = "DROP TABLE REGISTRATION";
            stmt.executeUpdate(sql);
            System.out.println("Table deleted in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
