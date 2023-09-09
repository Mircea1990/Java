package org.mySQLv2.statements;

import org.mySQLv2.TestApplication;

import java.sql.*;

public class PreparedStatementExample {
    private static final String UPDATE_QUERY = "UPDATE Employees set age = ? WHERE id = ?";

    public static void main(String[] args) {
        //open connection
        try (Connection conn = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME, TestApplication.USERNAME,
                TestApplication.PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY)) {
            //bind values into the parameters
            preparedStatement.setInt(1, 35); // setting first parameter (age)
            preparedStatement.setInt(2, 102); //setting second parameter (ID)

            //update age of the record with ID = 102
            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows impacted: " + rows);

            //let's select all records and display them
            ResultSet resultSet = preparedStatement.executeQuery(StatementExample.QUERY);

            //extract date from result set
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("id"));
                System.out.println(" Age: " + resultSet.getInt("age"));
                System.out.println(" First Name: " + resultSet.getString("first_name"));
                System.out.println(" Last Name: " + resultSet.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
