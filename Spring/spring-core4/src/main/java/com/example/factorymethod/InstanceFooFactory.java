package com.example.factorymethod;

// This is a public class named InstanceFooFactory.
public class InstanceFooFactory {
    // This is a public method named createInstance.
    // It does not take any parameters.
    public Foo createInstance() {
        // This method returns a new instance of the Foo class.
        return new Foo();
    }
}

