package org.mySQLv2.batch;

import org.mySQLv2.TestApplication;

import java.sql.*;
import java.util.Arrays;

public class BatchingWithPrepareStatementObject {

    static final String INSERT_QUERY =
            "INSERT INTO Employees(first_name,last_name,age) VALUES(?, ?, ?)";

    public static void printResultSet(ResultSet rs) throws SQLException {
        // Ensure we start with first row
        rs.beforeFirst();
        while (rs.next()) {
            // Display values
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first_name"));
            System.out.println(", Last: " + rs.getString("last_name"));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME, TestApplication.USERNAME,
                TestApplication.PASSWORD);
             
             //defining a PreparedStatement object that represents a precompiled SQL statement
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY,
                                                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                            ResultSet.CONCUR_UPDATABLE)) {
            conn.setAutoCommit(false);

            ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");
            printResultSet(rs);

            // Set the variables
            stmt.setString(1, "Pappu");
            stmt.setString(2, "Singh");
            stmt.setInt(3, 33);
            // Add it to the batch
            stmt.addBatch();

            // Set the variables
            stmt.setString(1, "Pawan");
            stmt.setString(2, "Singh");
            stmt.setInt(3, 31);
            // Add it to the batch
            stmt.addBatch();

            // Create an int[] to hold returned values
            int[] count = stmt.executeBatch();
            System.out.println(Arrays.toString(count));
            //Explicitly commit statements to apply changes
            conn.commit();

            rs = stmt.executeQuery("Select * from Employees");
            printResultSet(rs);

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
