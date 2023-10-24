package com.example.getbean;

// The Tiger class implements the Animal interface from the AnnotationConfig package
class Tiger implements AnnotationConfig.Animal {
    // A private final variable to store the name of the Tiger
    private final String name;

    // Constructor for the Tiger class that takes a String as an argument
    Tiger(String name) {
        // Assigns the input name to the class variable 'name'
        this.name = name;
    }

    // Method to get the name of the Tiger
    String getName() {
        // Returns the name of the Tiger
        return name;
    }
}

