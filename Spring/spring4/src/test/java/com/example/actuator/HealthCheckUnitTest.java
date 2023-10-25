package com.example.actuator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

// The @RunWith(MockitoJUnitRunner.class) annotation tells JUnit to run the test using Mockito's
// testing support.
@RunWith(MockitoJUnitRunner.class)

public class HealthCheckUnitTest {
    // The @Test annotation tells JUnit that the public void method to which it is attached can
    // be run as a test case.
    @Test public void whenCheckMethodReturnsZero_thenHealthMethodReturnsStatusUP() {
        // Mockito.spy() method is used to create a spy instance of HealthCheck class.
        HealthCheck healthCheck = Mockito.spy(new HealthCheck());

        // when() method is used to configure simple return behavior for a spy or mock.
        when(healthCheck.check()).thenReturn(0);

        // health() method is called on the spy instance.
        Health health = healthCheck.health();

        // assertThat() is a statement in JUnit. If the statement does not throw an exception,
        // then the test case is assumed to have succeeded.
        assertThat(health.getStatus(), is(Status.UP));
    }

    @Test public void whenCheckMethodReturnsOtherThanZero_thenHealthMethodReturnsStatusDOWN() {
        // Mockito.spy() method is used to create a spy instance of HealthCheck class.
        HealthCheck healthCheck = Mockito.spy(new HealthCheck());

        // when() method is used to configure simple return behavior for a spy or mock.
        when(healthCheck.check()).thenReturn(-1);

        // health() method is called on the spy instance.
        Health health = healthCheck.health();

        // assertThat() is a statement in JUnit. If the statement does not throw an exception,
        // then the test case is assumed to have succeeded.
        assertThat(health.getStatus(), is(Status.DOWN));
    }
}

