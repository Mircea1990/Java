package org.example.DataAccessObject;

import org.example.DataTransferObject.UserDto;

/**
 * represents a contract for accessing and manipulating user data in a data storage system, such as
 * a database. It defines a set of methods that provide functionality related to user operations.
 * The interface acts as a bridge between the application code and the actual data storage system,
 * providing a consistent way to interact with user data.
 */
public interface UserDao {
    UserDto getUserById(int id);

    UserDto getUserByEmail(String email);

    void saveUser(UserDto user);
}
