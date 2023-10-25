package com.example.spring43.defaultmethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

// This is an interface named ITransactionalUnitTest.
public interface ITransactionalUnitTest {

    // A Logger instance is created for this interface using the LoggerFactory.
    // This will be used to log information about the transactions.
    Logger log = LoggerFactory.getLogger(ITransactionalUnitTest.class);

    // This is a default method that will be executed before a transaction.
    // The @BeforeTransaction annotation indicates that this method should be run before the
    // transaction starts.
    @BeforeTransaction default void beforeTransaction() {
        // Logs the information that a transaction is being opened.
        log.info("Opening transaction");
    }

    // This is a default method that will be executed after a transaction.
    // The @AfterTransaction annotation indicates that this method should be run after the
    // transaction ends.
    @AfterTransaction default void afterTransaction() {
        // Logs the information that a transaction is being closed.
        log.info("Closing transaction");
    }
}

