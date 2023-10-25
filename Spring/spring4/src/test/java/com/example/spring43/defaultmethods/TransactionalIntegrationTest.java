package com.example.spring43.defaultmethods;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

// This annotation is used to specify the Java class that contains the Spring configuration.
@ContextConfiguration(classes = TransactionalTestConfiguration.class)

// This class is a test class that extends AbstractTransactionalJUnit4SpringContextTests,
// which is a convenient base class for JUnit 4.12+ tests that need to test something involving
// Spring components
// within a transactional context. It also implements the ITransactionalUnitTest interface.
public class TransactionalIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests
        implements ITransactionalUnitTest {

    // This is a test method annotated with @Test. The purpose of this test is to check if the
    // default method
    // annotated with @BeforeTransaction is executed as expected.
    @Test
    public void whenDefaultMethodAnnotatedWithBeforeTransaction_thenDefaultMethodIsExecuted() {
        // The actual test code would go here.
    }
}

