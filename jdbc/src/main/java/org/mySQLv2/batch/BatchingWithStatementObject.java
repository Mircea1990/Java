package org.mySQLv2.batch;

import org.mySQLv2.TestApplication;

import java.sql.*;

public class BatchingWithStatementObject {

    public static void printResultSet(ResultSet resultSet) throws SQLException {
        //ensure we point the cursor just before the first row
        resultSet.beforeFirst();

        while (resultSet.next()) { //Moves the cursor forward one row from its current position
            //display values
            System.out.println("Id: " + resultSet.getInt("id"));
            System.out.println("Age: " + resultSet.getInt("age"));
            System.out.println("First Name: " + resultSet.getString("first_name"));
            System.out.println("Last Name: " + resultSet.getString("last_name"));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //open a connection
        try (Connection connection = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME, TestApplication.USERNAME,
                TestApplication.PASSWORD);
             //defining the Statement object used for executing a static SQL
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                              ResultSet.CONCUR_UPDATABLE)) {

            //set autocommit to false
            connection.setAutoCommit(false);

            //create a result set object
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees");
            printResultSet(resultSet);

            //create SQL statement
            String sql = "INSERT INTO Employees (age, first_name, last_name) VALUES (26, 'Ana', " +
                         "'Popescu')";
            //add above sql statement to the bach
            statement.addBatch(sql);

            //create one more SQL command
            sql = "INSERT INTO Employees (age, first_name, last_name) VALUES (34, 'Irina', " +
                  "'Vasilescu')";

            //add the new command to batch
            statement.addBatch(sql);

            //create one more SQL statement
            sql = "UPDATE Employees SET age= 40 where id=2";
            statement.addBatch(sql);

            //create an int[] to hold update counts
            int[] count = statement.executeBatch();

            //explicitly commit statements to apply changes
            connection.commit();

            resultSet = statement.executeQuery("SELECT * FROM Employees");
            printResultSet(resultSet);
            resultSet.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
