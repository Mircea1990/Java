package com.example.spring43.depresolution;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertNotNull;

// @ContextConfiguration is a Spring annotation used to specify the application context
// configuration to load for an integration test.
// Here, it's loading the configuration from the ObjectProviderConfiguration class.
@ContextConfiguration(classes = ObjectProviderConfiguration.class)

// ObjectProviderIntegrationTest is the name of your test class. It extends
// AbstractJUnit4SpringContextTests,
// a convenient base class for JUnit 4.5+ based tests which need to use Spring's testing features.
public class ObjectProviderIntegrationTest extends AbstractJUnit4SpringContextTests {

    // @Autowired is used to automatically wire the FooService into this class,
    // allowing you to use it to access the methods of FooService.
    @Autowired private FooService fooService;

    // @Test is a JUnit annotation indicating that the public void method to which it is attached
    // can be run as a test case.
    @Test public void whenArgumentIsObjectProvider_thenObjectProviderInjected() {
        // assertNotNull is a JUnit assertion that checks that an object isn't null.
        // Here, it's checking that getRepository() method of fooService doesn't return null.
        assertNotNull(fooService.getRepository());
    }
}
