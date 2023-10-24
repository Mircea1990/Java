package com.example.getbean;

// The Lion class implements the Animal interface from the AnnotationConfig class.
class Lion implements AnnotationConfig.Animal {
    // This is a private final field for the Lion class. It represents the name of the lion.
    private final String name;

    // This is a constructor for the Lion class. It's used to create a new instance of Lion with
    // an initial name value.
    Lion(String name) {
        this.name = name; // Sets the name of the lion to the passed value.
    }

    // This is a getter method for the name field. It's used to access the value of the name
    // field of an existing Lion object.
    String getName() {
        return name; // Returns the name of the lion.
    }
}

