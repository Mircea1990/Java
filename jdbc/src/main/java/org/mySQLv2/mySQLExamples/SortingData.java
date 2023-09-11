package org.mySQLv2.mySQLExamples;

import org.mySQLv2.TestApplication;

import java.sql.*;

public class SortingData {

    static final String QUERY = "SELECT id, first, last, age FROM Registration";

    public static void main(String[] args) {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME, TestApplication.USERNAME,
                TestApplication.PASSWORD); Statement stmt = conn.createStatement()) {
            System.out.println("Fetching records in ascending order...");
            ResultSet rs = stmt.executeQuery(QUERY + " ORDER BY first ASC");
            while (rs.next()) {
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.println(", Last: " + rs.getString("last"));
            }

            System.out.println("Fetching records in descending order...");
            rs = stmt.executeQuery(QUERY + " ORDER BY first DESC");
            while (rs.next()) {
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.println(", Last: " + rs.getString("last"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
