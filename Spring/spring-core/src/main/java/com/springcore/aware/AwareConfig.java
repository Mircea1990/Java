package com.springcore.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springcore.aware")
public class AwareConfig {
    @Bean(name = "myCustomBeanName")
    public MyBeanName getMyBeanName() {
        return new MyBeanName();
    }

    @Bean
    public MyBeanFactory getMyBeanFactory() {
        return new MyBeanFactory();
    }
}
