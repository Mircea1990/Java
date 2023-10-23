package com.springcore.springbean;

import com.springcore.springbean.domain.Address;
import com.springcore.springbean.domain.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Company.class)
public class Config {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Company company = context.getBean(Company.class);
        System.out.println(company);
    }

    @Bean
    public Address getAddress() {
        return new Address("High Street", 1000);
    }
}
