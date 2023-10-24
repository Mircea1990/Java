package com.springcore.streamutils;

import org.springframework.stereotype.Component;

import java.io.InputStream;

// The @Component annotation indicates that this class is a component.
// A component is a Java class that is detected and automatically registered as a bean in the
// Spring IoC container.
@Component public class DrainStream {
    // This method returns an InputStream.
    // The InputStream returned is a nullInputStream which is an InputStream that always returns
    // EOF (end of file),
    // giving the effect of an empty stream. This can be useful in testing scenarios.
    public InputStream getInputStream() {
        return InputStream.nullInputStream();
    }
}

