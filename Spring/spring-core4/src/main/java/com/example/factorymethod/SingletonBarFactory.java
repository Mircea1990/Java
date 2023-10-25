package com.example.factorymethod;

// This is a public class named SingletonBarFactory.
public class SingletonBarFactory {
    // This is a private static final variable named INSTANCE.
    // It's an instance of the Bar class, initialized with the name "unnamed".
    private static final Bar INSTANCE = new Bar("unnamed");

    // This is a public static method named createInstance.
    // It takes a String parameter named name.
    public static Bar createInstance(String name) {
        // This line sets the name of the INSTANCE to the provided name.
        INSTANCE.setName(name);
        // This method returns the INSTANCE of the Bar class.
        return INSTANCE;
    }
}

