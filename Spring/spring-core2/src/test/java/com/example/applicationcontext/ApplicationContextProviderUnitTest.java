package com.example.applicationcontext;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// The @ContextConfiguration annotation is used to specify the application context configuration
// to load for this test class.
// The classes attribute specifies the annotated classes to use for loading an ApplicationContext.
@ContextConfiguration(classes = TestContextConfig.class)
// The @ExtendWith annotation is used to register extensions for the annotated test class or test
// method.
// SpringExtension.class integrates the Spring TestContext Framework into JUnit 5's Jupiter
// programming model.
@ExtendWith(SpringExtension.class) class ApplicationContextProviderUnitTest {
    // This test method checks if the ApplicationContext is not null and prints the number of
    // beans in it.
    @Test void whenGetApplicationContext_thenReturnApplicationContext() {
        // Get the ApplicationContext
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
        // Check if the context is not null
        assertNotNull(context);
        // Print the number of beans in the ApplicationContext
        System.out.printf("ApplicationContext has %d beans %n", context.getBeanDefinitionCount());
    }

    // This test method checks if a bean of type ItemService can be retrieved from the
    // ApplicationContext.
    @Test void whenGetBean_thenReturnItemServiceReference() {
        // Get the ApplicationContext
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
        // Check if the context is not null
        assertNotNull(context);
        // Get a bean of type ItemService from the context
        ItemService itemService = context.getBean(ItemService.class);
        // Check if the retrieved bean is not null
        assertNotNull(context);
        // Print the item from the ItemService
        System.out.println(itemService.getItem());
    }
}
