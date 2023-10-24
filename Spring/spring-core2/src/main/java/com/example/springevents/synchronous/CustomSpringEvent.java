package com.example.springevents.synchronous;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

// The @Getter annotation is a Lombok annotation to auto-generate getter methods for all fields.
@Getter
// CustomSpringEvent is a class that extends the ApplicationEvent class from the Spring Framework.
public class CustomSpringEvent extends ApplicationEvent {
    // serialVersionUID is used for serialization and deserialization. It's a version control in a Serializable class.
    private static final long serialVersionUID = -8053143381029977953L;
    // This is a private field that holds the message of this event.
    private String message;

    // This is the constructor for the CustomSpringEvent class.
    public CustomSpringEvent(final Object source, final String message) {
        // It calls the parent constructor with the source object.
        super(source);
        // It sets the message of this event.
        this.message = message;
    }
}

