package com.example.bean.injection;

import com.example.bean.config.SetterBasedShipConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// This is a test class for testing setter-based bean injection with Java configuration
public class SetterBasedBeanInjectionWithJavaConfigIntegrationTest {
    // This is a constant for the expected helm brand name
    private static final String HELM_NAME = "HelmBrand";

    // This is a test method
    @Test
    public void givenJavaConfigFile_whenUsingSetterBasedBeanInjection_thenCorrectHelmName() {
        // Create a new AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // Register the configuration class SetterBasedShipConfig with the context
        ctx.register(SetterBasedShipConfig.class);
        // Refresh the context, causing all beans to get loaded and initialized
        ctx.refresh();
        // Get the Ship bean from the context
        Ship ship = ctx.getBean(Ship.class);
        // Assert that the brand of the helm in the ship is as expected
        Assertions.assertEquals(HELM_NAME, ship.getHelm().getBrandOfHelm());
    }
}

