package com.example.spring.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

// @Configuration
// Enable Spring's annotation-driven transaction management capability
@EnableTransactionManagement
// Load properties from the specified classpath resource
@PropertySource({"classpath:persistence-mysql.properties"})
// Scan the specified package for Spring components
@ComponentScan({"com.example.persistence"})
// Indicate that this class is a source of bean definitions
@Configuration public class PersistenceConfig {
    // Autowire the Environment object, which represents the environment in which the current
    // application is running
    @Autowired private Environment env;

    public PersistenceConfig() {
        super();
    }

    // Define a bean for the SessionFactory, which is used to create Hibernate sessions
    @Bean public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        // Set the DataSource that should be used to create connections
        sessionFactory.setDataSource(restDataSource());
        // Set the base packages to scan for entity classes
        sessionFactory.setPackagesToScan(new String[]{"com.example.spring.persistence.model"});
        // Set Hibernate properties such as hbm2ddl.auto and dialect
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    // Define a bean for the DataSource, which is used to obtain connections to the database
    @Bean public DataSource restDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Set the JDBC driver class name, URL, username, and password from properties
        dataSource.setDriverClassName(
                Objects.requireNonNull(env.getProperty("jdbc.driverClassName")));
        dataSource.setUrl(
                Objects.requireNonNull(Objects.requireNonNull(env.getProperty("jdbc.url"))));
        dataSource.setUsername(Objects.requireNonNull(env.getProperty("jdbc.user")));
        dataSource.setPassword(Objects.requireNonNull(env.getProperty("jdbc.pass")));
        return dataSource;
    }

    // Define a bean for the transaction manager, which is used to manage transactions in a
    // Hibernate environment
    @Bean
    public HibernateTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        final HibernateTransactionManager txManager = new HibernateTransactionManager();
        // Set the SessionFactory that this instance should manage transactions for
        txManager.setSessionFactory(entityManagerFactory.unwrap(SessionFactory.class));
        return txManager;
    }

    // Define a bean for the exception translation post processor, which adds an advisor to any
    // bean annotated with Repository so that any platform-specific exceptions are caught and
    // then rethrown as one of Spring's unchecked data access exceptions (i.e., a subclass of
    // DataAccessException)
    @Bean public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    // Define Hibernate properties such as hbm2ddl.auto and dialect from properties
    final Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
                                        env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        return hibernateProperties;
    }
}
