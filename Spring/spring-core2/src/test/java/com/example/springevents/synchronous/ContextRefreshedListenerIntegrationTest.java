package com.example.springevents.synchronous;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.springframework.util.Assert.isTrue;

// This annotation tells JUnit to run the test with SpringJUnit4ClassRunner which is a custom
// extension of JUnit's BlockJUnit4ClassRunner which provides functionality of the Spring
// TestContext Framework.
@RunWith(SpringJUnit4ClassRunner.class)
// This annotation is used to specify which configuration files to use to initialize the
// ApplicationContext for integration tests.
@ContextConfiguration(classes = {SynchronousSpringEventsConfig.class},
                      loader = AnnotationConfigContextLoader.class)
// This is the test class for ContextRefreshedListener.
public class ContextRefreshedListenerIntegrationTest {
    // The @Autowired annotation is used for automatic dependency injection.
    @Autowired private ContextRefreshedListener listener;

    // The @Test annotation tells JUnit that the public void method to which it is attached can
    // be run as a test case.
    @Test public void testContextRefreshedListener() {
        // Print a message to the console.
        System.out.println("Test context re-freshed listener.");
        // Assert that the context refresh handler was hit once. If not, it will throw an
        // AssertionError with the given message.
        isTrue(listener.isHitContextRefreshedHandler(), "Refresh should be called once");
    }
}
