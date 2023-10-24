package com.example.customscope;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class TenantScopeIntegrationTest {
    @Test
    // This test method checks if the context contains 'foo' and 'bar' beans when scope and beans
    // are registered.
    public final void whenRegisterScopeAndBeans_thenContextContainsFooAndBar() {
        // Create a new AnnotationConfigApplicationContext in a try-with-resources block.
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
            // Register the TenantScopeConfig class with the context.
            ctx.register(TenantScopeConfig.class);
            // Register the TenantBeansConfig class with the context.
            ctx.register(TenantBeansConfig.class);
            // Refresh the context, causing it to be initialized with the registered
            // configuration classes.
            ctx.refresh();
            // Get the 'foo' bean of type TenantBean from the context.
            TenantBean foo = (TenantBean) ctx.getBean("foo", TenantBean.class);
            // Call the sayHello method on the 'foo' bean.
            foo.sayHello();
            // Get the 'bar' bean of type TenantBean from the context.
            TenantBean bar = (TenantBean) ctx.getBean("bar", TenantBean.class);
            // Call the sayHello method on the 'bar' bean.
            bar.sayHello();
            // Get all beans of type TenantBean from the context.
            Map<String, TenantBean> foos = ctx.getBeansOfType(TenantBean.class);
            // Assert that 'foo' and 'bar' are not equal.
            assertThat(foo, not(equalTo(bar)));
            // Assert that there are 2 beans of type TenantBean in the context.
            assertThat(foos.size(), equalTo(2));
            // Assert that 'foo' is in the map of TenantBeans.
            assertTrue(foos.containsValue(foo));
            // Assert that 'bar' is in the map of TenantBeans.
            assertTrue(foos.containsValue(bar));
            // Get the BeanDefinition for 'foo'.
            BeanDefinition fooDefinition = ctx.getBeanDefinition("foo");
            // Get the BeanDefinition for 'bar'.
            BeanDefinition barDefinition = ctx.getBeanDefinition("bar");
            // Assert that the scope of 'foo' is "tenant".
            assertThat(fooDefinition.getScope(), equalTo("tenant"));
            // Assert that the scope of 'bar' is "tenant".
            assertThat(barDefinition.getScope(), equalTo("tenant"));
        }
    }

    @Test
    // This test method checks if the context contains 'foo' and 'bar' beans when component
    // scanning is performed.
    public final void whenComponentScan_thenContextContainsFooAndBar() {
        // Create a new AnnotationConfigApplicationContext in a try-with-resources block.
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
            // Perform component scanning on "com.example.customscope".
            ctx.scan("com.example.customscope");
            // Refresh the context, causing it to be initialized with any beans defined in
            // scanned components.
            ctx.refresh();

            /* The rest of this method is identical to
            whenRegisterScopeAndBeans_thenContextContainsFooAndBar() */
            TenantBean foo = (TenantBean) ctx.getBean("foo", TenantBean.class);
            foo.sayHello();
            TenantBean bar = (TenantBean) ctx.getBean("bar", TenantBean.class);
            bar.sayHello();
            Map<String, TenantBean> foos = ctx.getBeansOfType(TenantBean.class);
            assertThat(foo, not(equalTo(bar)));
            assertThat(foos.size(), equalTo(2));
            assertTrue(foos.containsValue(foo));
            assertTrue(foos.containsValue(bar));
            BeanDefinition fooDefinition = ctx.getBeanDefinition("foo");
            BeanDefinition barDefinition = ctx.getBeanDefinition("bar");
            assertThat(fooDefinition.getScope(), equalTo("tenant"));
            assertThat(barDefinition.getScope(), equalTo("tenant"));
        }
    }
}
