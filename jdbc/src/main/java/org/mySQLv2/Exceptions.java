package org.mySQLv2;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Exceptions {

    private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "learn_it_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String QUERY = "{ call getEmpName (?,?)}";

    public static void main(String[] args) {

        //open a connection
        try (var conn = DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, USERNAME, PASSWORD);
             CallableStatement callableStatement = conn.prepareCall(QUERY)) {

            //bind values into the parameters
            callableStatement.setInt(1, 103); // this would set ID

            //because second parameter is OUT so register if
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);

            //use execute method to run stored procedure
            System.out.println("Executing stored procedure...");
            callableStatement.execute();

            //retrieve employee name with getXXX method
            String employeeName = callableStatement.getString(2);
            System.out.println("Employee name with ID 101: " + employeeName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
