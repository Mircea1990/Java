package org.example.impl;

import org.example.DataAccessObject.RoleDao;
import org.example.DataTransferObject.RoleDto;
import org.example.utilClass.DBUtils;

import java.sql.SQLException;

/*
 * implementation of the RoleDao interface. It provides functionality to retrieve role data from a
 * MySQL database using JDBC (Java Database Connectivity)
 */
public class MySqlJdbcRoleDao implements RoleDao {

    /**
     * This method is responsible for retrieving role data from the database based on the provided
     * id. It returns a RoleDto object representing the role with the specified id.
     *
     * @param id
     * @return
     */
    @Override public RoleDto getRoleById(int id) {
        /*
         * It first establishes a database connection using DBUtils.getConnection() that returns
         * a valid
         * connection to the MySQL database.
         */
        try (var conn = DBUtils.getConnection(); var ps = conn.prepareStatement(

                //SELECT query that retrieves the role data from the role table based on the id.
                "SELECT * FROM role WHERE id = ?")) {

            //It sets the id parameter in the prepared statement using ps.setInt(1, id).
            ps.setInt(1, id);

            //It executes the query using ps.executeQuery() and obtains a ResultSet object.
            try (var rs = ps.executeQuery()) {

                /*
                 *It checks if the ResultSet contains any rows using rs.next(). If there is at
                 * least one row, it creates a new RoleDto object, sets its properties using the
                 * data from the ResultSet, and returns it.
                 */
                if (rs.next()) {
                    RoleDto role = new RoleDto();
                    role.setId(rs.getInt("id"));
                    role.setRoleName(rs.getString("role_name"));
                    return role;
                }
            }

            /*
             *Any SQLException that occurs during the execution of the method is caught, and the
             * stack trace is printed.
             */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
