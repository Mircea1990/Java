package com.example.spring43.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
    // Logger instance for logging events of this class
    private static final Logger log = LoggerFactory.getLogger(Foo.class);

    // Static AtomicInteger to keep track of the number of instances of this class
    private static final AtomicInteger instanceCount = new AtomicInteger(0);

    // Instance variable to store the instance number of this object
    private final int instanceNum;

    // Constructor for the Foo class
    public Foo() {
        // Increment the instanceCount and assign the new value to instanceNum
        instanceNum = instanceCount.incrementAndGet();
    }

    // Static method to get the current instance count
    public static int getInstanceCount() {
        return instanceCount.get();
    }

    // Method to print the instance number of this object
    public void printInstanceNumber() {
        log.info("Foo instance number: {}", instanceNum);
    }
}

