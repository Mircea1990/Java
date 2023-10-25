package com.example.factorymethod;

// This class is a factory for creating instances of the Bar class.
public class InstanceBarFactory {
    // This method creates a new instance of the Bar class with the provided name.
    public Bar createInstance(String name) {
        return new Bar(name);
    }
}

