package com.example.springevents.synchronous;

import org.junit.Ignore;
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
// This is the test class for SynchronousCustomSpringEvents.
public class SynchronousCustomSpringEventsIntegrationTest {
    // The @Autowired annotation is used for automatic dependency injection.
    @Autowired private CustomSpringEventPublisher publisher;
    @Autowired private AnnotationDrivenEventListener listener;

    // The @Test annotation tells JUnit that the public void method to which it is attached can
    // be run as a test case.
    @Test public void testCustomSpringEvents() {
        // Assert that the custom event handler was not hit initially. If not, it will throw an
        // AssertionError with the given message.
        isTrue(!listener.isHitCustomEventHandler(), "The value should be false");
        // Publish a custom event with the message "Hello world!!".
        publisher.publishCustomEvent("Hello world!!");
        // Print a message to the console.
        System.out.println("Done publishing synchronous custom event. ");
        // Assert that the custom event handler was hit after the event was published. If not, it
        // will throw an AssertionError with the given message.
        isTrue(listener.isHitCustomEventHandler(), "Now the value should be changed to true");
    }

    @Test public void testGenericSpringEvent() {
        // Assert that the successful event handler was not hit initially. If not, it will throw
        // an AssertionError with the given message.
        isTrue(!listener.isHitSuccessfulEventHandler(), "The initial value should be false");
        // Publish a generic event with the message "Hello world!!!" and a success status of true.
        publisher.publishGenericEvent("Hello world!!!", true);
        // Assert that the successful event handler was hit after the successful event was
        // published. If not, it will throw an AssertionError with the given message.
        isTrue(listener.isHitSuccessfulEventHandler(), "Now the value should be changed to true");
    }

    @Test public void testGenericSpringEventNotProcessed() {
        // Assert that the successful event handler was not hit initially. If not, it will throw
        // an AssertionError with the given message.
        isTrue(!listener.isHitSuccessfulEventHandler(), "The initial value should be false");
        // Publish a generic event with the message "Hello world!!!" and a success status of false.
        publisher.publishGenericEvent("Hello world!!!", false);
        // Assert that the successful event handler was still not hit after the unsuccessful
        // event was published. If not, it will throw an AssertionError with the given message.
        isTrue(!listener.isHitSuccessfulEventHandler(), "The value should still be false");
    }

    // The @Ignore annotation is used to ignore this test case. It will not be executed.
    @Ignore("fix me") @Test public void testContextStartedEvent() {
        // Assert that the context started handler was hit once. If not, it will throw an
        // AssertionError with the given message.
        isTrue(listener.isHitContextStartedHandler(), "Start should be called once");
    }
}

