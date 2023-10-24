package com.example.springevents.synchronous;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.springframework.util.Assert.isTrue;

// This annotation tells JUnit to run the test with SpringJUnit4ClassRunner which is a custom extension of JUnit's BlockJUnit4ClassRunner which provides functionality of the Spring TestContext Framework.
@RunWith(SpringJUnit4ClassRunner.class)
// This annotation is used to specify which configuration files to use to initialize the ApplicationContext for integration tests.
@ContextConfiguration(classes = {SynchronousSpringEventsConfig.class}, loader = AnnotationConfigContextLoader.class)
// This is the test class for GenericAppEventListener.
public class GenericAppEventListenerIntegrationTest {
    // The @Autowired annotation is used for automatic dependency injection.
    @Autowired
    private CustomSpringEventPublisher publisher;
    @Autowired
    private GenericSpringEventListener listener;

    // The @Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
    @Test
    public void testGenericSpringEvent() {
        // Assert that the event handler was not hit initially. If not, it will throw an AssertionError with the given message.
        isTrue(!listener.isHitEventHandler(), "The initial value should be false");
        // Publish a generic application event with the message "Hello world!!!".
        publisher.publishGenericAppEvent("Hello world!!!");
        // Assert that the event handler was hit after the event was published. If not, it will throw an AssertionError with the given message.
        isTrue(listener.isHitEventHandler(), "Now the value should be changed to true");
    }
}
