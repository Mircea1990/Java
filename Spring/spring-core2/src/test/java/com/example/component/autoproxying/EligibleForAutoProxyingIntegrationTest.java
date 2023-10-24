package com.example.component.autoproxying;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

// This is a test class for testing auto-proxying in Spring with Java configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        // The classes to be loaded into the application context
        classes = {EligibleForAutoProxyRandomIntProcessor.class, DataCache.class, RandomIntGenerator.class})
public class EligibleForAutoProxyingIntegrationTest {
    // MemoryAppender for logging events
    private static MemoryLogAppender memoryAppender;
    // The processor to be tested
    private EligibleForAutoProxyRandomIntProcessor randomIntProcessor;
    // Autowired DataCache instance
    @Autowired
    private DataCache dataCache;

    // Setup method to initialize the logger and memory appender
    @BeforeClass
    public static void setup() {
        // Create a new MemoryLogAppender
        memoryAppender = new MemoryLogAppender();
        // Set the logger context for the memory appender
        memoryAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
        // Get the logger for "org.springframework.context"
        Logger logger = (Logger) LoggerFactory.getLogger("org.springframework.context");
        // Set the log level to INFO
        logger.setLevel(Level.INFO);
        // Add the memory appender to the logger
        logger.addAppender(memoryAppender);
        // Start the memory appender
        memoryAppender.start();
    }

    // Test method to check if a bean is not eligible for auto-proxying
    @Test
    public void givenAutowireInBeanPostProcessor_whenSpringContextInitialize_thenNotEligibleLogShouldShowAndGroupFieldPopulated() {
        // Search for log events indicating that a bean is not eligible for auto-proxying
        List<ILoggingEvent> notEligibleEvents = memoryAppender.search(
                "Bean 'randomIntGenerator' of type [com.example.component.autoproxying.RandomIntGenerator] " +
                        "is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)");
        // Assert that there are no such events
        assertEquals(0, notEligibleEvents.size());
        // Assert that the group field in the data cache is populated (not zero)
        assertNotEquals(0, dataCache.getGroup());
    }
}
