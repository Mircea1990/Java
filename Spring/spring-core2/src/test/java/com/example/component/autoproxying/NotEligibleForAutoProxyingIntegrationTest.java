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

// This class is a test class that uses SpringJUnit4ClassRunner to run tests within the Spring ApplicationContext
@RunWith(SpringJUnit4ClassRunner.class)
// This annotation is used to specify which classes to use for loading the application context
@ContextConfiguration(
        classes = {NotEligibleForAutoProxyRandomIntProcessor.class, DataCache.class, RandomIntGenerator.class})
public class NotEligibleForAutoProxyingIntegrationTest {
    // MemoryAppender instance for logging events
    private static MemoryLogAppender memoryAppender;
    // Instance of NotEligibleForAutoProxyRandomIntProcessor
    private NotEligibleForAutoProxyRandomIntProcessor proxyRandomIntProcessor;
    // Autowired instance of DataCache
    @Autowired
    private DataCache dataCache;

    // This method sets up the logger before all tests
    @BeforeClass
    public static void setup() {
        memoryAppender = new MemoryLogAppender();
        memoryAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
        Logger logger = (Logger) LoggerFactory.getLogger("org.springframework.context");
        logger.setLevel(Level.INFO);
        logger.addAppender(memoryAppender);
        memoryAppender.start();
    }

    // This test method checks if a specific log message is present when the Spring context is initialized
    @Test
    public void givenAutowireInBeanPostProcessor_whenSpringContextInitialize_thenNotEligibleLogShouldShowAndGroupFieldNotPopulated() {
        List<ILoggingEvent> notEligibleEvents = memoryAppender.search(
                "Bean 'randomIntGenerator' of type [com.example.component.autoproxying.RandomIntGenerator] " +
                        "is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)");
        assertEquals(1, notEligibleEvents.size());
        assertEquals(0, dataCache.getGroup());
    }
}

