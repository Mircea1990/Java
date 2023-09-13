package org.example.DataTransferObject;

/**
 * a Data Transfer Object (DTO) class that represents a role entity in an application. It is used to
 * transfer user-related data between different layers or components of the application
 */
public class RoleDto {
    private int id;
    private String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override public String toString() {
        return "RoleDto [id=" + id + ", roleName=" + roleName + "]";
    }
}
