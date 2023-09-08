package org.oracle;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JavaDatabaseConnectivityDriver {

    static final String DB_URL =
            "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS = (PROTOCOL = TCP)" + "(HOST = localhost)" +
            "(PORT = 1521))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = MirceaDB)))";
    static final String DB_USER = "c##mircea";
    static final String DB_PASSWORD = "mircea";

    public static void main(String[] args) throws RuntimeException, SQLException {

        OracleDataSource ods = new OracleDataSource();
        ods.setURL(DB_URL);
        ods.setUser(DB_USER);
        ods.setPassword(DB_PASSWORD);

        // With AutoCloseable, the connection is closed automatically.
        try (OracleConnection connection = (OracleConnection) ods.getConnection()) {
            // Get the JDBC driver name and version
            DatabaseMetaData dbmd = connection.getMetaData();
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("Database Username is: " + connection.getUserName());
        }
    }
}
