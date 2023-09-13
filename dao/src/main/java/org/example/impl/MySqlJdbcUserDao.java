package org.example.impl;

import org.example.DataAccessObject.RoleDao;
import org.example.DataAccessObject.UserDao;
import org.example.DataTransferObject.UserDto;
import org.example.utilClass.DBUtils;

import java.sql.SQLException;

/*
this class is an implementation of the UserDao interface. It provides functionality to interact
with user data in a MySQL database using JDBC (Java Database Connectivity)
 */
public class MySqlJdbcUserDao implements UserDao {

    /**
     * This is a private field of type RoleDao that holds a reference to a RoleDao implementation.
     * It is initialized in an instance initializer block by creating an instance of
     * MySqlJdbcRoleDao
     */
    private final RoleDao roleDao;

    /*
    MySqlJdbcUserDao class depends on the RoleDao interface and uses the
    MySqlJdbcRoleDao implementation to retrieve role data.
     */ {
        roleDao = new MySqlJdbcRoleDao();
    }

    /*
    This method retrieves user data from the database based on the provided id. It returns a
    UserDto object representing the user with the specified id.
    */
    @Override public UserDto getUserById(int id) {
        try (var conn = DBUtils.getConnection(); var ps = conn.prepareStatement(
                "SELECT * FROM user WHERE id = ?")) {

            ps.setInt(1, id);
            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    UserDto user = new UserDto();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(roleDao.getRoleById(rs.getInt("fk_user_role")));
                    user.setMoney(rs.getBigDecimal("money"));
                    user.setCreditCard(rs.getString("credit_card"));
                    return user;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    This method retrieves user data from the database based on the provided email. It returns a
    UserDto object representing the user with the specified email.
     */
    @Override public UserDto getUserByEmail(String email) {
        try (var conn = DBUtils.getConnection(); var ps = conn.prepareStatement(
                "SELECT * FROM user WHERE email = ?")) {

            ps.setString(1, email);
            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    UserDto user = new UserDto();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(roleDao.getRoleById(rs.getInt("fk_user_role")));
                    user.setMoney(rs.getBigDecimal("money"));
                    user.setCreditCard(rs.getString("credit_card"));
                    return user;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    This method saves a UserDto object to the database. It inserts a new user record with the
    provided user data. The implementation uses a parameterized SQL INSERT statement to insert
    the user's first name, last name, email, role ID, money, and credit card information into the
     user table.
     */
    @Override public void saveUser(UserDto user) {
        try (var conn = DBUtils.getConnection(); var ps = conn.prepareStatement(
                "INSERT INTO user (first_name, last_name, email, fk_user_role, " +
                "money, credit_card) VALUES (?, ?, ?, ?, ?, ?);")) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            if (user.getRole() != null) {
                ps.setInt(4, user.getRole().getId());
            } else {
                ps.setNull(4, java.sql.Types.NULL);
            }
            ps.setBigDecimal(5, user.getMoney());
            ps.setString(6, user.getCreditCard());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
