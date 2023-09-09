package org.mySQL.statement;

import org.mySQL.DBUtils;

import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertStatementExample {
    public static void main(String[] args) throws SQLException {
        String query = "INSERT INTO user (first_name,last_name,email,money)" +
                       " VALUES ('Mircea', 'Stefanescu','mircea@yahoo.com', 1000)";
        try (var conn = DBUtils.getConnection(); Statement statement = conn.createStatement()) {
            int row = statement.executeUpdate(query);
            System.out.println(row + " rows updated");
        }
    }
}
