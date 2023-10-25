package com.example.spring43.ctor;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertNotNull;

// This annotation is used to specify the classes that will be used to load the context for this
// test.
// In this case, it's loading the configurations for FooRepository and FooService.
@ContextConfiguration(classes = {FooRepositoryConfiguration.class, FooServiceConfiguration.class})

// This is the test class. It extends AbstractJUnit4SpringContextTests,
// which is a base class for JUnit 4.5+ based tests which require Spring's testing features.
public class ConfigurationConstructorInjectionIntegrationTest
        extends AbstractJUnit4SpringContextTests {

    // The @Autowired annotation is used by Spring to automatically inject an instance of
    // FooService into this field.
    @Autowired public FooService fooService;

    // This is a test method. The @Test annotation tells JUnit that this method should be run as
    // a test case.
    // In this case, it's testing that when there's a single constructor in the configuration,
    // the context loads normally and the repository within fooService is not null.
    @Test public void whenSingleCtorInConfiguration_thenContextLoadsNormally() {
        // assertNotNull is an assertion method provided by JUnit.
        // It checks that the object passed as parameter is not null.
        assertNotNull(fooService.getRepository());
    }
}

