package com.springcore.streamutils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class CopyStream {
    public static String getStringFromInputStream(InputStream input) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(input, writer, "UTF-8");
        return writer.toString();
    }

    public InputStream getNonClosingInputStream() throws IOException {
        InputStream in = new ClassPathResource("input.txt").getInputStream();
        return StreamUtils.nonClosing(in);
    }
}
