package org.behavioral.strategy;

//will implement Startegy interface
public class Multiplication implements Strategy {

    @Override
    public float calculation(float a, float b) {
        return a * b;
    }
}
