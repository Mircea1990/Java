package org.mySQL.statement;

import org.mySQL.DBUtils;

import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDeleteStatementExample {
    public static void main(String[] args) throws SQLException {
        String query = "DELETE FROM user WHERE id = 18";

        try (var conn = DBUtils.getConnection(); Statement statement = conn.createStatement()) {
            int rows = statement.executeUpdate(query);
            System.out.println(rows + " rows deleted");
        }
    }
}
