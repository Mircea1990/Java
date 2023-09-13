package org.example.DataAccessObject;

import org.example.DataTransferObject.RoleDto;

/**
 * represents a contract for accessing and manipulating role data in a data storage system, such as
 * a database. It defines a method that provide functionality related to user operations. The
 * interface acts as a bridge between the application code and the actual data storage system,
 * providing a consistent way to interact with user data.
 */
public interface RoleDao {
    RoleDto getRoleById(int id);
}
