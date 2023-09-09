package org.mySQLv2.resultSet;

import org.mySQLv2.TestApplication;

import java.sql.*;

public class UpdatingResultSet {
    public static void main(String[] args) {
        //open a connection
        try (Connection connection = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME, TestApplication.USERNAME,
                TestApplication.PASSWORD);
             Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                         ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(TestApplication.QUERY)) {

            System.out.println("List result set for reference....");
            printResultSet(rs);

            //loop through result set and add 5 in age
            //move to Before first position so while-loop works properly
            rs.beforeFirst();
            //extract data from result set
            while (rs.next()) {
                //retrieve by column name
                int newAge = rs.getInt("age") + 5;
                rs.updateInt("age", newAge);
                rs.updateRow();
            }

            System.out.println("List result set showing new ages...");
            printResultSet(rs);

            //insert a record into table
            //move to insert row and add column data with updateXXX()
            System.out.println("Inserting a new record...");
            rs.moveToInsertRow();
            rs.updateString("first_name", "Mircea");
            rs.updateString("last_name", "Stefanescu");
            rs.updateInt("age", 33);
            //commit row
            rs.insertRow();

            System.out.println("List result set showing new set...");
            printResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printResultSet(ResultSet rs) throws SQLException {
        //ensure we start from the first row
        rs.beforeFirst();
        while (rs.next()) {
            //display values
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("First Name: " + rs.getString("first_name"));
            System.out.println("Last Name: " + rs.getString("last_name"));
        }
        System.out.println();
    }
}
