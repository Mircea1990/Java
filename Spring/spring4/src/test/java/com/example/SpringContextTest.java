package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.example.flips.ApplicationConfig;

// The @RunWith(SpringJUnit4ClassRunner.class) annotation tells JUnit to run the test using
// Spring's testing support.
// SpringJUnit4ClassRunner is the new name for SpringJUnit4ClassRunner in Spring 5.
@RunWith(SpringJUnit4ClassRunner.class)

// The @ContextConfiguration annotation is used to specify the application context configuration
// to load for this test fixture.
// Here, it's loading the configuration from the ApplicationConfig class.
@ContextConfiguration(classes = ApplicationConfig.class)

// The @WebAppConfiguration is a class-level annotation that is used to declare that the
// ApplicationContext loaded for an integration test should be a WebApplicationContext.
@WebAppConfiguration

public class SpringContextTest {

    // The @Test annotation tells JUnit that the public void method to which it is attached can
    // be run as a test case.
    // Here, it's testing that no exceptions are thrown when the Spring context is bootstrapped.
    @Test public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}

