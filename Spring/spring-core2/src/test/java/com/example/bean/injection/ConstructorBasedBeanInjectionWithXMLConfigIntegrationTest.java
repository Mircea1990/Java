package com.example.bean.injection;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// This is a test class for testing constructor-based bean injection with XML configuration
public class ConstructorBasedBeanInjectionWithXMLConfigIntegrationTest {
    // This is a constant for the expected helm brand name
    private static final String HELM_NAME = "HelmBrand";

    // This is a test method
    @Test
    public void givenXMLConfigFile_whenUsingConstructorBasedBeanInjection_thenCorrectHelmName() {
        // Load the XML configuration file and create an ApplicationContext
        final ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beanInjection-constructor.xml");
        // Get the Ship bean from the context
        final Ship shipConstructorBean = (Ship) applicationContext.getBean("ship");
        // Assert that the brand of the helm in the ship is as expected
        Assert.assertEquals(HELM_NAME, shipConstructorBean.getHelm().getBrandOfHelm());
    }
}

