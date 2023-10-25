package com.example.factorymethod;

// This is a public class named SingletonFooFactory.
public class SingletonFooFactory {
    // This is a private static final variable named INSTANCE.
    // It's an instance of the Foo class, initialized with a new Foo object.
    private static final Foo INSTANCE = new Foo();

    // This is a public static method named createInstance.
    // It does not take any parameters.
    public static Foo createInstance() {
        // This method returns the INSTANCE of the Foo class.
        return INSTANCE;
    }
}

