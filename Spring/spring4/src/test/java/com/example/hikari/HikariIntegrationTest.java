package com.example.hikari;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// This is a Spring Boot test class for testing the HikariCP connection pool.
// It uses the SpringRunner, which is a bridge between Spring Boot test features and JUnit.
@RunWith(SpringRunner.class)

// The @SpringBootTest annotation tells Spring Boot to look for the main configuration class
// (one with @SpringBootApplication) and use that to start a Spring application context.
// Here, it's also used to specify that the type of the data source should be HikariDataSource.
@SpringBootTest(properties = "spring.datasource.type=com.zaxxer.hikari.HikariDataSource")

public class HikariIntegrationTest {

    @Autowired
    // This annotation allows Spring to resolve and inject collaborating beans into our bean.
    private DataSource dataSource;
            // DataSource is an interface in Java for handling a set of JDBC operations.

    @Test
    // This annotation tells JUnit that the public void method to which it is attached can be run
    // as a test case.
    public void hikariConnectionPoolIsConfigured() {
        // This test case checks if the HikariCP connection pool is configured correctly.
        // It asserts that the class name of the dataSource bean should be 'com.zaxxer.hikari
        // .HikariDataSource'.
        assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass().getName());
    }
}

