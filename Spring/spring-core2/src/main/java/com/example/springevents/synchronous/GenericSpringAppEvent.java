package com.example.springevents.synchronous;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

// The @Getter annotation is a Lombok annotation to auto-generate getter methods for all fields.
@Getter
// GenericSpringAppEvent is a class that extends the ApplicationEvent class from the Spring Framework.
// It's a generic class that can handle events of any type.
public class GenericSpringAppEvent<T> extends ApplicationEvent {
    // This is a private field that holds the event data of type T.
    private final T what;

    // This is the constructor for the GenericSpringAppEvent class.
    public GenericSpringAppEvent(final Object source, final T what) {
        // It calls the parent constructor with the source object.
        super(source);
        // It sets the event data.
        this.what = what;
    }
}
