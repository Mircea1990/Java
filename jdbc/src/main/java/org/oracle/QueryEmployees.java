package org.oracle;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.ResultSet;
import java.sql.Statement;

public class QueryEmployees {

    public static void main(String[] args) throws Exception {

        OracleDataSource ods = new OracleDataSource();
        ods.setURL(JavaDatabaseConnectivityDriver.DB_URL);
        ods.setUser(JavaDatabaseConnectivityDriver.DB_USER);
        ods.setPassword(JavaDatabaseConnectivityDriver.DB_PASSWORD);

        // With AutoCloseable, the connection is closed automatically.
        try (OracleConnection connection = (OracleConnection) ods.getConnection()) {
            int size = 0;
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM angajati");
            while (resultSet.next()) {
                size++;
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " +
                                   resultSet.getString(3));
            }
            System.out.println("Number of employees: " + size);
        }
    }
}
