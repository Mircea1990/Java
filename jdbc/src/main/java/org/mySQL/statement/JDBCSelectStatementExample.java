package org.mySQL.statement;

import org.mySQL.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelectStatementExample {
    public static void main(String[] args) throws SQLException {
        String query = "SELECT * FROM user";
        try (var conn = DBUtils.getConnection(); Statement statement = conn.createStatement()) {
            try (ResultSet rs = statement.executeQuery(query)) {
                while (rs.next()) {
                    System.out.println("----------------");
                    System.out.println("Id: " + rs.getInt("ID"));
                    System.out.println("First Name: " + rs.getString("first_name"));
                    System.out.println("Last Name: " + rs.getString("last_name"));
                    System.out.println("Email: " + rs.getString("email"));
                    System.out.println("Role: " + rs.getString("fk_user_role"));
                }
            }
        }

    }
}
