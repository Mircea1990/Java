package com.example;

import com.example.beanpostprocessor.*;
import com.example.escapehtml.HtmlEscapeUtils;
import com.example.factorymethod.*;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.Date;

public class MainClass {
    public static void main(String[] args) {
        // Subscribe, unsubscribe and post to a global event bus
        GlobalEventBus.subscribe(new Object());
        GlobalEventBus.unsubscribe(new Object());
        GlobalEventBus.post(new Object());

        // Create a bean factory and apply a post processor to it
        ConfigurableListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        GuavaEventBusBeanFactoryPostProcessor postProcessor =
                new GuavaEventBusBeanFactoryPostProcessor();
        postProcessor.postProcessBeanFactory(beanFactory);

        // Create a bean post processor and apply it to a bean before and after initialization
        GuavaEventBusBeanPostProcessor beanPostProcessor = new GuavaEventBusBeanPostProcessor();
        Object bean = new Object();
        String beanName = "exampleBean";
        beanPostProcessor.postProcessBeforeInitialization(bean, beanName);
        beanPostProcessor.postProcessAfterInitialization(bean, beanName);

        // Create a stock trade and publish it using a stock trade publisher
        StockTrade stockTrade = new StockTrade("symbol", 10, 100.0, new Date());
        StockTradePublisher stockTradePublisher = new StockTradePublisher();
        stockTradePublisher.handleNewStockTradeEvent(stockTrade);

        // Escape HTML using Apache Commons and print the result
        String escapedHtml = HtmlEscapeUtils.escapeWithApacheCommons("<html>");
        System.out.println("Escaped HTML: " + escapedHtml);

        // Create a bar, print its name, change its name and print the new name
        Bar bar = new Bar("Bar");
        System.out.println("Bar name: " + bar.getName());
        bar.setName("New Bar");
        System.out.println("New Bar name: " + bar.getName());

        // Create a foo instance and print a message
        Foo foo = new Foo();
        System.out.println("Foo instance created");

        // Create an instance of bar using an instance factory and print its name
        InstanceBarFactory instanceBarFactory = new InstanceBarFactory();
        Bar instanceBar = instanceBarFactory.createInstance("Instance Bar");
        System.out.println("Instance Bar name: " + instanceBar.getName());

        // Create an instance of foo using an instance factory and print a message
        InstanceFooFactory instanceFooFactory = new InstanceFooFactory();
        Foo instanceFoo = instanceFooFactory.createInstance();
        System.out.println("Instance Foo created");

        // Create a singleton instance of bar using a singleton factory and print its name
        Bar singletonBar = SingletonBarFactory.createInstance("Singleton Bar");
        System.out.println("Singleton Bar name: " + singletonBar.getName());

        // Create a singleton instance of foo using a singleton factory and print a message
        Foo singletonFoo = SingletonFooFactory.createInstance();
        System.out.println("Singleton Foo created");
    }
}

