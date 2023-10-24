package com.example.spring.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // This annotation is used to indicate that the class declares one or more @Bean methods.
@ComponentScan("com.example")  // This annotation is used to specify the base packages for component scanning.
public class CoreConfig implements
        WebMvcConfigurer {  // This class implements the WebMvcConfigurer interface for callback configuration of a Web MVC application.
    public CoreConfig() {  // Constructor of this class.
        super();  // Calls the constructor of the superclass.
    }
    // beans

    @Bean  // This annotation is used to indicate that a method produces a bean to be managed by the Spring container.
    public ExecutorService setupExecutor() {  // This method creates a ThreadPoolExecutor bean.
        final int coreThreads = 4;  // The number of threads to keep in the pool, even if they are idle.
        final int maxThreads = 8;  // The maximum number of threads to allow in the pool.
        final ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(coreThreads, maxThreads, 60L, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>());  // Creates a new ThreadPoolExecutor with given initial parameters.
        threadPoolExecutor.allowCoreThreadTimeOut(
                true);  // Sets the policy governing whether core threads may time out and terminate if no tasks arrive.
        return threadPoolExecutor;  // Returns the created ThreadPoolExecutor.
    }

}
