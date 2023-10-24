package com.example.factorybean;

import lombok.Getter;

// The @Getter annotation is a part of Project Lombok and it generates a getter for all
// non-static fields.
@Getter public class Tool {
    // This is a private field for the Tool class. It represents the id of the tool.
    private int id;

    // This is a parameterized constructor for the Tool class. It's used to create a new instance
    // of Tool with an initial id value.
    public Tool(int id) {
        this.id = id; // Sets the id of the tool to the passed value.
    }

    // This is a setter method for the id field. It's used to change the value of the id field of
    // an existing Tool object.
    public void setId(int id) {
        this.id = id; // Sets the id of the tool to the passed value.
    }
}

