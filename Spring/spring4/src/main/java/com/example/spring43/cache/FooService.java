package com.example.spring43.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

// The @Service annotation is a specialization of the component annotation.
// It doesn't currently provide any additional behavior over the @Component annotation,
// but it's a good idea to use @Service over @Component in service-layer classes because
// it specifies intent better.
@Service public class FooService {

    // The @Cacheable annotation is used to simplify the cache mechanism in Spring applications.
    // The 'cacheNames' attribute indicates the name of the cache where the results are stored.
    // The 'sync' attribute is used to indicate whether multiple threads are allowed to
    // execute the method simultaneously or not. If 'sync' is true, only one thread will be
    // allowed to execute the method at a time. Other threads will have to wait until the first
    // thread completes execution.
    @Cacheable(cacheNames = "foos", sync = true) public Foo getFoo(String id) {
        // Creates a new instance of Foo and returns it.
        return new Foo();
    }
}

