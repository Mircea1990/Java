package com.springcore.streamutils;

import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class DrainStream {
    public InputStream getInputStream() {
        return InputStream.nullInputStream();
    }
}
