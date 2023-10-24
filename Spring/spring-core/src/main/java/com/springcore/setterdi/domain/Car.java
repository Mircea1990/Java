package com.springcore.setterdi.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// This annotation is used to indicate that this class is a Spring component. It will be
// automatically detected during classpath scanning.
public class Car {
    // Declare the dependencies of this class.
    private Engine engine;
    private Transmission transmission;
    private Trailer trailer;

    public Car() {
        // Default constructor.
    }

    @Autowired // This annotation is used to automatically inject the Engine bean into this class.
    public void setEngine(Engine engine) {
        this.engine = engine; // Set the engine instance variable to the provided engine.
    }

    @Autowired
    // This annotation is used to automatically inject the Transmission bean into this class.
    public void setTransmission(Transmission transmission) {
        this.transmission =
                transmission; // Set the transmission instance variable to the provided
        // transmission.
    }

    @Autowired // This annotation is used to automatically inject the Trailer bean into this class.
    public void setTrailer(Trailer trailer) {
        this.trailer = trailer; // Set the trailer instance variable to the provided trailer.
    }

    @Override public String toString() {
        // Override the toString method to return a string representation of this object.
        return String.format("Engine: %s Transmission: %s Trailer: %s", engine, transmission,
                             trailer);
    }
}

