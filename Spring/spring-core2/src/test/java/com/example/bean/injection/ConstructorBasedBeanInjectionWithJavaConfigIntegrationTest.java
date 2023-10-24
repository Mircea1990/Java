package com.example.bean.injection;

import com.example.bean.config.ConstructorBasedShipConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// This is a test class for testing constructor-based bean injection with Java configuration
public class ConstructorBasedBeanInjectionWithJavaConfigIntegrationTest {
    // This is a constant for the expected helm brand name
    private static final String HELM_NAME = "HelmBrand";

    // This is a test method
    @Test
    public void givenJavaConfigFile_whenUsingConstructorBasedBeanInjection_thenCorrectHelmName() {
        // Create a new AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // Register the configuration class ConstructorBasedShipConfig with the context
        ctx.register(ConstructorBasedShipConfig.class);
        // Refresh the context, causing all beans to get loaded and initialized
        ctx.refresh();
        // Get the Ship bean from the context
        Ship ship = ctx.getBean(Ship.class);
        // Assert that the brand of the helm in the ship is as expected
        Assert.assertEquals(HELM_NAME, ship.getHelm().getBrandOfHelm());
    }
}
