package com.example.scopes;

import lombok.Getter;

// The @Getter annotation is used to generate a getter method for the field
@Getter public class HelloMessageGenerator {
    // message is a private String that will store the message
    private String message;

    // Setter method for the message field
    public void setMessage(final String message) {
        this.message = message;
    }
}

