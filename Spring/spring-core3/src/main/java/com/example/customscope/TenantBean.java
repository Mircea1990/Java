package com.example.customscope;

// This is the TenantBean class.
public class TenantBean {
    // The name of the tenant. This is a final field, meaning that it can only be set once and
    // cannot be changed after it is set.
    private final String name;

    // This is the constructor for the TenantBean class. It initializes the name of the tenant.
    public TenantBean(String name) {
        this.name = name;
    }

    // This method prints a hello message from the tenant. It uses the name of the tenant and the
    // class name in its message.
    public void sayHello() {
        System.out.printf("Hello from %s of type %s%n", this.name, this.getClass().getName());
    }
}

