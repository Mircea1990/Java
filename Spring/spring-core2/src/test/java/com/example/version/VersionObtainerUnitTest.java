package com.example.version;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

// The @SpringBootTest annotation is used to specify that this is a Spring Boot test and to specify which classes to use to initialize the ApplicationContext for integration tests.
@SpringBootTest(classes = VersionObtainer.class)
// This is the test class for VersionObtainer.
public class VersionObtainerUnitTest {
    // An instance of VersionObtainer is created.
    public VersionObtainer version = new VersionObtainer();

    // The @Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
    @Test
    public void testGetSpringVersion() {
        // The getSpringVersion method of the VersionObtainer instance is called and the result is stored in the variable 'res'.
        String res = version.getSpringVersion();
        // Assert that the result is not empty. If it is, it will throw an AssertionError.
        assertThat(res).isNotEmpty();
    }

    @Test
    public void testGetJdkVersion() {
        // The getJdkVersion method of the VersionObtainer instance is called and the result is stored in the variable 'res'.
        String res = version.getJdkVersion();
        // Assert that the result is not empty. If it is, it will throw an AssertionError.
        assertThat(res).isNotEmpty();
    }

    @Test
    public void testGetJavaVersion() {
        // The getJavaVersion method of the VersionObtainer instance is called and the result is stored in the variable 'res'.
        String res = version.getJavaVersion();
        // Assert that the result is not empty. If it is, it will throw an AssertionError.
        assertThat(res).isNotEmpty();
    }
}

