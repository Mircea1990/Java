package org.mySQLv2.transactions;

import org.mySQLv2.TestApplication;

import java.sql.*;

public class CommitRollbackExample {
    static final String INSERT_QUERY =
            "INSERT INTO Employees (age, first_name, last_name) values(20, 'Rita', 'Tez')";
    static final String INSERT_QUERY_2 =
            "INSERT INTO Employees (age, first_name, last_name) values(20, 'Sita', 'Singh')";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        try {
            //open a connection
            con = DriverManager.getConnection(
                    TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME,
                    TestApplication.USERNAME, TestApplication.PASSWORD);

            //set auto commit as false
            con.setAutoCommit(false);

            //execute a query to create statement with required arguments for ResultSet
            System.out.println("Creating a statement");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                       ResultSet.CONCUR_UPDATABLE);

            //insert a row into Employees table
            System.out.println("Inserting one row....");
            stmt.executeUpdate(INSERT_QUERY);

            //insert one more row into Employees table
            stmt.executeUpdate(INSERT_QUERY_2);

            //commit data here
            System.out.println("Committing data here....");
            con.commit();

            //now list all the available records
            ResultSet rs = stmt.executeQuery(TestApplication.QUERY);
            System.out.println("List result set for reference...");
            printResultSet(rs);

            //clean-up environment
            rs.close();
            stmt.close();
            con.close();
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
