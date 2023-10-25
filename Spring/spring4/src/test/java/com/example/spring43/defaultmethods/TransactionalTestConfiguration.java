package com.example.spring43.defaultmethods;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;

// This annotation indicates that this class is a configuration class that may have methods
// annotated with @Bean.
@Configuration public class TransactionalTestConfiguration {

    // This method is annotated with @Bean, indicating that it's a factory for a bean that will
    // be managed by Spring.
    // The returned DataSource object will be registered as a bean in the Spring application
    // context.
    @Bean public DataSource getDataSource() {
        // Creating an instance of SimpleDriverDataSource, which is a simple implementation of
        // the standard JDBC DataSource interface,
        // configuring JDBC driver class and connection details.
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();

        // Setting the JDBC driver class.
        simpleDriverDataSource.setDriverClass(org.hsqldb.jdbcDriver.class);

        // Setting the connection URL for an HSQLDB in-memory database.
        simpleDriverDataSource.setUrl("jdbc:hsqldb:mem:app-db");

        // Setting the username for the database connection.
        simpleDriverDataSource.setUsername("sa");

        // Setting the password for the database connection.
        simpleDriverDataSource.setPassword("");

        // Returning the configured DataSource object.
        return simpleDriverDataSource;
    }

    // This method is annotated with @Bean, indicating that it's a factory for a bean that will
    // be managed by Spring.
    // The returned PlatformTransactionManager object will be registered as a bean in the Spring
    // application context.
    @Bean public PlatformTransactionManager transactionManager() {
        // Creating an instance of DataSourceTransactionManager, which is an implementation of
        // PlatformTransactionManager
        // for a single JDBC DataSource. This object manages transactions for the DataSource
        // returned by getDataSource().
        return new DataSourceTransactionManager(getDataSource());
    }
}

