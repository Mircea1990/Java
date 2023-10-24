package com.example.springevents.synchronous;

// This class extends the GenericSpringEvent class and specifies that the event data type is String.
public class GenericStringSpringEvent extends GenericSpringEvent<String> {
    // Constructor for this class.
    // It calls the constructor of the superclass (GenericSpringEvent) with the provided string
    // and success flag.
    GenericStringSpringEvent(final String what, final boolean success) {
        super(what, success);
    }
}

