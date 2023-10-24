package com.example.springevents.synchronous;

import lombok.Getter;

// The @Getter annotation is a Lombok annotation to auto-generate getter methods for all fields.
@Getter
// GenericSpringEvent is a generic class that can handle events of any type.
public class GenericSpringEvent<T> {
    // This is a protected field that holds the success status of the event.
    protected final boolean success;
    // This is a private field that holds the event data of type T.
    private final T what;

    // This is the constructor for the GenericSpringEvent class.
    public GenericSpringEvent(final T what, final boolean success) {
        // It sets the event data and success status.
        this.what = what;
        this.success = success;
    }
}

