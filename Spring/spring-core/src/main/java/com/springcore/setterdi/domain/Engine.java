package com.springcore.setterdi.domain;

public class Engine {
    // Declare the instance variables for this class.
    private String type; // The type of the engine.
    private int volume; // The volume of the engine.

    public Engine() {
        // Default constructor.
    }

    public void setType(String type) {
        this.type = type; // Set the type instance variable to the provided type.
    }

    public void setVolume(int volume) {
        this.volume = volume; // Set the volume instance variable to the provided volume.
    }

    @Override
    public String toString() {
        // Override the toString method to return a string representation of this object.
        return String.format("%s %d", type, volume);
    }
}
