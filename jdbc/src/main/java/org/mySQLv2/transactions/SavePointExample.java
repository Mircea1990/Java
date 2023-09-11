package org.mySQLv2.transactions;

import org.mySQLv2.TestApplication;

import java.sql.*;

public class SavePointExample {

    private static final String QUERY = "SELECT id, age, first_name, last_name FROM Employees";
    private static final String DELETE_QUERY = "DELETE FROM Employees WHERE ID = 14";
    // existing id
    private static final String DELETE_QUERY_1 = "DELETE FROM Employees WHERE ID = 15";
    // existing id

    public static void printResultsSet(ResultSet resultSet) throws SQLException {
        //ensure we start from first row
        resultSet.beforeFirst();
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("Age: " + resultSet.getInt("age"));
            System.out.println("First Name: " + resultSet.getString("first_name"));
            System.out.println("Last Name: " + resultSet.getString("last_name"));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //open connection
        try (Connection connection = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME, TestApplication.USERNAME,
                TestApplication.PASSWORD); Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            connection.setAutoCommit(false);

            ResultSet rs = statement.executeQuery(QUERY);
            System.out.println("List result set for reference...");
            printResultsSet(rs);

            //delete row having ID 14
            //but save point before doing so
            Savepoint savepoint1 = connection.setSavepoint("ROW_DELETED_1");
            System.out.println("Deleting row with id 14...");
            statement.executeUpdate(DELETE_QUERY);

            //rollback the changes after save point 1
            connection.rollback(savepoint1);

            //delete row having id 15
            //but save point before doing so
            connection.setSavepoint("ROW_DELETED_2");
            System.out.println("Deleting row with id 15...");

            statement.executeUpdate(DELETE_QUERY_1);

            rs = statement.executeQuery(QUERY);
            System.out.println("List result set after deletion....");
            printResultsSet(rs);

            //clean up environment
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
