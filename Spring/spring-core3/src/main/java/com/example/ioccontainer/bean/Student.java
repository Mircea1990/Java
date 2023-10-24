package com.example.ioccontainer.bean;

// The Student class
public class Student {
    // A private static boolean variable to check if the bean is instantiated
    private static boolean isBeanInstantiated = false;

    // Method to check if the bean is instantiated
    public static boolean isBeanInstantiated() {
        // Returns the status of the bean instantiation
        return isBeanInstantiated;
    }

    // Method to set the status of the bean instantiation
    public static void setBeanInstantiated(boolean isBeanInstantiated) {
        // Sets the status of the bean instantiation
        Student.isBeanInstantiated = isBeanInstantiated;
    }

    // Method to be called after bean construction
    public void postConstruct() {
        // Sets the status of the bean instantiation to true
        setBeanInstantiated(true);
    }
}

