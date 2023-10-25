package com.example.spring43.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertEquals;

// The @ContextConfiguration annotation is used to specify the application context for the test.
// It loads the configuration from the CacheRefinementsConfiguration class.
@ContextConfiguration(classes = CacheRefinementsConfiguration.class)
public class CacheRefinementsIntegrationTest extends AbstractJUnit4SpringContextTests {
    // ExecutorService is a higher-level replacement for working with threads directly. Executors
    // are capable of managing a pool of threads, so we do not have to manually create new
    // threads and run tasks in an asynchronous fashion.
    // Here we are creating a thread pool of 10 threads using Executors.newFixedThreadPool(10).
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    // The @Autowired annotation is used to auto-wire spring bean on setter methods, instance
    // variable, and constructor.
    // Here it's injecting an instance of FooService into this test class.
    @Autowired private FooService service;

    // The @Test annotation tells JUnit that the public void method to which it is attached can
    // be run as a test case.
    // This test case is checking if the cacheable method getFoo() is executed only once when
    // multiple threads execute it with sync set to true.
    @Test
    public void whenMultipleThreadsExecuteCacheableMethodWithSyncTrue_thenMethodIsExecutedOnlyOnce()
            throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            // We are executing the getFoo() method of the service in each thread.
            executorService.execute(() -> service.getFoo("test").printInstanceNumber());
        }
        // This line makes the current thread wait until all tasks have completed execution after
        // a shutdown request, or the timeout occurs, or the current thread is interrupted,
        // whichever happens first.
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        // Assert class is used for writing test cases, assertEquals checks if the two objects
        // are equal.
        // Here we are checking if the instance count of Foo is 1.
        assertEquals(1, Foo.getInstanceCount());
    }
}

