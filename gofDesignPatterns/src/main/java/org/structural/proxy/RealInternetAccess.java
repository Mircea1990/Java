package org.structural.proxy;

//class that will implement OfficeInternetAccess interface for granting the permission to the specific employee
public class RealInternetAccess implements OfficeInternetAccess {

    private final String employeeName;

    public RealInternetAccess(String empName) {
        this.employeeName = empName;
    }

    @Override
    public void grantInternetAccess() {
        System.out.println("Internet Access granted for employee: " + employeeName);
    }
}
