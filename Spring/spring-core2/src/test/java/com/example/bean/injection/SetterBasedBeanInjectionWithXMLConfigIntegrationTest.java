package com.example.bean.injection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// This is a test class for testing setter-based bean injection with XML configuration
public class SetterBasedBeanInjectionWithXMLConfigIntegrationTest {
    // This is a constant for the expected helm brand name
    private static final String HELM_NAME = "HelmBrand";

    // This is a test method
    @Test
    public void givenXMLConfigFile_whenUsingSetterBasedBeanInjection_thenCorrectHelmName() {
        // Load the XML configuration file and create an ApplicationContext
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanInjection-setter.xml");
        // Get the Ship bean from the context
        final Ship shipSetterBean = (Ship) applicationContext.getBean("ship");
        // Assert that the brand of the helm in the ship is as expected
        Assert.assertEquals(HELM_NAME, shipSetterBean.getHelm().getBrandOfHelm());
    }
}

