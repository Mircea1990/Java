package com.example.actuator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

// The @RunWith(SpringRunner.class) annotation tells JUnit to run the test using Spring's testing
// support.
@RunWith(SpringRunner.class)

// The @SpringBootTest annotation tells Spring Boot to look for a main configuration class
// (one with @SpringBootApplication, for instance) and use that to start a Spring application
// context.
@SpringBootTest(classes = LoginServiceImpl.class)

public class LoginServiceUnitTest {
    // @MockBean annotation is used to add mock objects to the Spring application context.
    // The mock will replace any existing bean of the same type in the application context.
    @MockBean CounterService counterService;

    // @Autowired annotation is used to auto-wire spring bean on setter methods, instance
    // variable, and constructor.
    @Autowired LoginServiceImpl loginService;

    // The @Test annotation tells JUnit that the public void method to which it is attached can
    // be run as a test case.
    @Test public void whenLoginUserIsAdmin_thenSuccessCounterIsIncremented() {
        // login() method is called on the loginService instance with "admin" as username and
        // "secret" as password.
        boolean loginResult = loginService.login("admin", "secret".toCharArray());

        // assertThat() is a statement in JUnit. If the statement does not throw an exception,
        // then the test case is assumed to have succeeded.
        assertThat(loginResult, is(true));

        // verify() method checks that certain behavior happened at least once / exact number of
        // times / never.
        verify(counterService, times(1)).increment("counter.login.success");
    }

    @Test public void whenLoginUserIsNotAdmin_thenFailureCounterIsIncremented() {
        // login() method is called on the loginService instance with "user" as username and
        // "notsecret" as password.
        boolean loginResult = loginService.login("user", "notsecret".toCharArray());

        // assertThat() is a statement in JUnit. If the statement does not throw an exception,
        // then the test case is assumed to have succeeded.
        assertThat(loginResult, is(false));

        // verify() method checks that certain behavior happened at least once / exact number of
        // times / never.
        verify(counterService, times(1)).increment("counter.login.failure");
    }
}

