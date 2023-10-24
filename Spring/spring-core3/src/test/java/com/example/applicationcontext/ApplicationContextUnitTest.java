package com.example.applicationcontext;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// This class contains unit tests for different types of application contexts in Spring.
public class ApplicationContextUnitTest {
    // This test checks if the beans are correctly loaded from an annotation-based configuration.
    @Test public void givenAnnotationConfigAppContext_whenSpringConfig_thenMappingSuccess() {
        // An application context is created from the AccountConfig class.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AccountConfig.class);
        // The AccountService bean is retrieved from the context.
        AccountService accountService = context.getBean(AccountService.class);
        // The test asserts that the AccountService bean and its repository are not null.
        assertNotNull(accountService);
        assertNotNull(accountService.getAccountRepository());
        // The context is closed to release resources.
        context.close();
    }

    // This test checks if the beans are correctly loaded from an XML configuration in the
    // classpath.
    @Test public void givenClasspathXmlAppContext_whenAnnotationConfig_thenMappingSuccess() {
        // An application context is created from an XML configuration file in the classpath.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationcontext/user-bean-config.xml");
        // The UserService bean is retrieved from the context.
        UserService userService = context.getBean(UserService.class);
        // The test asserts that the UserService bean is not null.
        assertNotNull(userService);
        // The context is closed to release resources.
        context.close();
    }

    // This test checks if the beans are correctly loaded from an XML configuration file in the
    // filesystem.
    // It's currently ignored and won't be run during testing.
    @Test @Ignore public void givenFileXmlAppContext_whenXMLConfig_thenMappingSuccess() {
        // The path to the XML configuration file in the filesystem.
        String path = "D:/workspaces/example/tutorials/spring-core-4/src/test/resources" +
                      "/applicationcontext/account-bean-config.xml";
        // An application context is created from the XML configuration file in the filesystem.
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(path);
        // The AccountService bean is retrieved from the context.
        AccountService accountService = context.getBean("accountService", AccountService.class);
        // The test asserts that the AccountService bean and its repository are not null.
        assertNotNull(accountService);
        assertNotNull(accountService.getAccountRepository());
        // The context is closed to release resources.
        context.close();
    }

    // This test checks if the beans are correctly loaded from an XML configuration in the
    // classpath.
    @Test public void givenClasspathXmlAppContext_whenXMLConfig_thenMappingSuccess() {
        // An application context is created from an XML configuration file in the classpath.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationcontext/account-bean-config.xml");
        // The AccountService bean is retrieved from the context.
        AccountService accountService = context.getBean("accountService", AccountService.class);
        // The test asserts that the AccountService bean and its repository are not null.
        assertNotNull(accountService);
        assertNotNull(accountService.getAccountRepository());
        // The context is closed to release resources.
        context.close();
    }

    // This test checks if a message resource (like a properties file) is correctly loaded and used.
    @Test public void givenMessagesInFile_whenMessageResourceUsed_thenReadMessage() {
        // An application context is created from the AccountConfig class.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AccountConfig.class);
        // The AccountService bean is retrieved from the context.
        AccountService accountService = context.getBean(AccountService.class);
        // The test asserts that the account name matches "TestAccount".
        assertEquals("TestAccount", accountService.getAccountName());
        // The context is closed to release resources.
        context.close();
    }
}
