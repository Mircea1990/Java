package org.mySQL;

import java.sql.SQLException;
import java.sql.Savepoint;

public class JDBCTransactionExample {
    public static void main(String[] args) {
        String updateQuery = "UPDATE user SET money = ? WHERE id = ?";
        String selectQuery = "SELECT * FROM user WHERE id = ?";

        double moneyToTransfer = 150;
        int userFromId = 12;
        int userToId = 18;

        try (var conn = DBUtils.getConnection();
             var psSelect = conn.prepareStatement(selectQuery);
             var psUpdate = conn.prepareStatement(updateQuery)) {
            Savepoint savepoint = null;

            try {
                conn.setAutoCommit(false);
                psSelect.setInt(1, userFromId);

            } catch (SQLException e) {
                e.printStackTrace();
                conn.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
