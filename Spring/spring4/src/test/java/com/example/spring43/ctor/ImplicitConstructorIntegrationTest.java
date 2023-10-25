package com.example.spring43.ctor;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertNotNull;

// The @ContextConfiguration annotation is used to specify the locations of XML configuration
// files that are used to load a Spring ApplicationContext for integration tests.
@ContextConfiguration("classpath:implicit-ctor-context.xml")
// This class extends AbstractJUnit4SpringContextTests, a convenient base class for JUnit 4.5+
// based tests which need to use Spring's testing features.
public class ImplicitConstructorIntegrationTest extends AbstractJUnit4SpringContextTests {

    // The @Autowired annotation is used to automatically inject the FooService bean into this
    // test class.
    @Autowired private FooService fooService;

    // The @Test annotation indicates that the public void method to which it is attached can be
    // run as a test case. In this case, it's testing that the repository in fooService is not null.
    @Test public void whenBeanWithoutAutowiredCtor_thenInjectIntoSingleCtor() {
        // assertNotNull is a JUnit method that asserts that the object passed as parameter is
        // not null. If it is null, the test case fails.
        assertNotNull(fooService.getRepository());
    }
}

