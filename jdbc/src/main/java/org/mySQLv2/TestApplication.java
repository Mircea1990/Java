package org.mySQLv2;

import java.sql.*;

public class TestApplication {

    public static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "learn_it_db";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static final String QUERY = "SELECT id, first_name, last_name, age FROM Employees";

    public static void main(String[] args) {

        // open connection
        try (Connection conn = DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, USERNAME,
                                                           PASSWORD);
             Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(QUERY)) {

            DriverManager.setLoginTimeout(1);

            //Extract date from result set
            while (result.next()) {
                //retrieve by column name
                System.out.println("Id: " + result.getInt("id"));
                System.out.println(" Age: " + result.getInt("age"));
                System.out.println(" First Name: " + result.getString("first_name"));
                System.out.println(" Last Name: " + result.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
