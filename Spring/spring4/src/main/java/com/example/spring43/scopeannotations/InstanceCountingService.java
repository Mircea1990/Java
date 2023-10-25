package com.example.spring43.scopeannotations;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

// This is a public class named InstanceCountingService.
// It is annotated with @Getter from the Lombok library, which automatically generates getter
// methods for all fields.
@Getter public class InstanceCountingService {
    // A private static final instance variable named instanceCount of type AtomicInteger.
    // It is initialized to 0. Being static, this variable will be shared by all instances of
    // this class.
    private static final AtomicInteger instanceCount = new AtomicInteger(0);

    // A private final instance variable named instanceNumber of type int.
    // It is assigned the incremented value of instanceCount.
    // This means each instance of this class will have a unique instanceNumber, starting from 1.
    private final int instanceNumber = instanceCount.incrementAndGet();
}

