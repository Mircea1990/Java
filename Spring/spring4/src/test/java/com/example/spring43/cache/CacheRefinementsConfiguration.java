package com.example.spring43.cache;

import java.util.Collections;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// The @Configuration annotation is used to indicate that the class can be used by the Spring IoC
// container as a source of bean definitions.
// The @ComponentScan annotation is used with the @Configuration annotation to tell Spring the
// packages to scan for annotated components.
// The @EnableCaching annotation triggers a post processor that inspects every Spring bean for
// the presence of caching annotations on public methods.
@Configuration @ComponentScan @EnableCaching public class CacheRefinementsConfiguration {

    // The @Bean annotation tells Spring that this method will return an object that should be
    // registered as a bean in the Spring application context.
    // The CacheManager interface is used to manage cache operations. Here we are using
    // SimpleCacheManager which is a basic, no frills implementation of CacheManager.
    // We are setting up a cache named "foos" using ConcurrentMapCache which is a simple Cache
    // implementation based on the core JDK java.util.concurrent package.
    @Bean public CacheManager cacheManager() {
        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Collections.singletonList(new ConcurrentMapCache("foos")));
        return manager;
    }
}

