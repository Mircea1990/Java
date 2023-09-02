package org.behavioral.memento;

//class that will Store internal state of the Originator object
public class Memento {

    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
