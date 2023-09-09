package org.mySQLv2.resultSet;

import org.mySQLv2.TestApplication;

import java.sql.*;

public class ViewingResultSet {
    public static void main(String[] args) {
        //open a connection
        try (Connection connection = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME, TestApplication.USERNAME,
                TestApplication.PASSWORD);
             Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                         ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(TestApplication.QUERY)) {

            //move cursor to the last row
            System.out.println("Moving cursor to the last...");
            rs.last();

            //extract data from result set
            System.out.println("Displaying record...");

            //retrieve by column name
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");

            //display values
            System.out.println("Id: " + id);
            System.out.println("Age: " + age);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);

            //move cursor to the first row
            System.out.println("Moving cursor to first...");
            rs.first();

            //extract data from result set
            System.out.println("Displaying record...");
            //retrive by column name
            id = rs.getInt("id");
            age = rs.getInt("age");
            firstName = rs.getString("first_name");
            lastName = rs.getString("last_name");

            //display record
            System.out.println("Id: " + id);
            System.out.println("Age: " + age);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);

            //move cursor to next row
            System.out.println("Moving cursor to next row...");
            rs.next();

            //extract data from current row
            System.out.println("Displaying info...");
            id = rs.getInt("id");
            age = rs.getInt("age");
            firstName = rs.getString("first_name");
            lastName = rs.getString("last_name");

            System.out.println("Id: " + id);
            System.out.println("Age: " + age);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
