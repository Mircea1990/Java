package com.example.springevents.synchronous;

// This class extends the GenericSpringAppEvent class and specifies that the event data type is
// String.
class GenericStringSpringAppEvent extends GenericSpringAppEvent<String> {
    // Constructor for this class.
    // It calls the constructor of the superclass (GenericSpringAppEvent) with the provided
    // source object and string.
    GenericStringSpringAppEvent(final Object source, final String what) {
        super(source, what);
    }
}

