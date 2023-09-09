package org.mySQL.statement;

import org.mySQL.DBUtils;

import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdateStatementExample {
    public static void main(String[] args) throws SQLException {
        String query = "UPDATE user SET money = 1780 where id = 17";
        try (var conn = DBUtils.getConnection(); Statement statement = conn.createStatement()) {
            int rows = statement.executeUpdate(query);
            System.out.println(rows + " updated");
        }
    }
}
