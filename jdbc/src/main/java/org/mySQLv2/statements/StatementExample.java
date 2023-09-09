package org.mySQLv2.statements;

import org.mySQLv2.TestApplication;

import java.sql.*;

public class StatementExample {

    public static final String QUERY = "SELECT id, first_name,last_name,age FROM Employees";
    private static final String UPDATE_QUERY = "UPDATE Employees set age=31 where id=103";

    public static void main(String[] args) {
        //open connection
        try (Connection conn = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME, TestApplication.USERNAME,
                TestApplication.PASSWORD); Statement statement = conn.createStatement()) {

            //let's check if it returns a true Result Set or not
            boolean resultSetValue = statement.execute(UPDATE_QUERY);
            System.out.println("Returning value: " + resultSetValue); // false

            //let's update age of the record with ID = 103
            int rows = statement.executeUpdate(UPDATE_QUERY);
            System.out.println("Returning value: " + rows); //1

            //let's select all the records and display them
            ResultSet resultSet = statement.executeQuery(QUERY);

            //extract data from result set
            while (resultSet.next()) {
                //retrieve by colum name
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println(" Age: " + resultSet.getInt("age"));
                System.out.println(" First Name: " + resultSet.getString("first_name"));
                System.out.println(" Last Name: " + resultSet.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
