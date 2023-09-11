package org.mySQLv2.batch;

import org.mySQLv2.TestApplication;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckIfSupportsBatch {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                TestApplication.JDBC_MYSQL_HOST + TestApplication.DB_NAME, TestApplication.USERNAME,
                TestApplication.PASSWORD)) {

            //Retrieve the DatabaseMetaData object from the connection
            DatabaseMetaData metaData = connection.getMetaData();

            //Use the supportsBatchUpdates() method to determine if batch update processing is
            // supported by the database
            boolean supportsBatchUpdates = metaData.supportsBatchUpdates();

            //perform further actions based on the result
            if (supportsBatchUpdates) {
                System.out.println("Batch update processing is supported.");
            } else {
                System.out.println("Batch update processing is not supported.");
            }
        }
    }
}
