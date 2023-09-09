package org.mySQLv2.statements;

import org.mySQLv2.TestApplication;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.Types.VARCHAR;

public class CallableStatementExample {
    private static final String QUERY = "{call getEmpName (?,?)}";

    public static void main(String[] args) {
        //open connection
        try (Connection connection = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME, TestApplication.USERNAME,
                TestApplication.PASSWORD);
             CallableStatement callableStatement = connection.prepareCall(QUERY)) {

            //bind values into the parameters
            callableStatement.setInt(1, 102); // set first parameter to ID

            // because second parameter is OUT we register it
            callableStatement.registerOutParameter(2, VARCHAR);

            //use execute method to run stored procedure
            System.out.println("Executing procedure...");
            callableStatement.execute();

            //retrieve employee name with getXXX method
            String empName = callableStatement.getString(2);

            System.out.println("Employee name with ID 102: " + empName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
