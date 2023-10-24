package com.springcore.streamutils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

// The @Component annotation is used in Spring Framework to denote a class as Component. It means
// that Spring will auto-detect these classes for dependency injection when annotation-based
// configuration and classpath scanning is used.
@Component public class CopyStream {
    // This method takes an InputStream as input and converts it to a String
    public static String getStringFromInputStream(InputStream input) throws IOException {
        // Creating a StringWriter object
        StringWriter writer = new StringWriter();
        // Using IOUtils.copy() method to copy the InputStream content to the StringWriter. The
        // content is decoded using UTF-8 character encoding.
        IOUtils.copy(input, writer, "UTF-8");
        // Converting the StringWriter content to a String and returning it
        return writer.toString();
    }

    // This method returns an InputStream that does not close the underlying stream when it is
    // closed
    public InputStream getNonClosingInputStream() throws IOException {
        // Getting an InputStream from a file named "input.txt" located in the classpath
        InputStream in = new ClassPathResource("input.txt").getInputStream();
        // Wrapping the InputStream with a non-closing InputStream using StreamUtils.nonClosing()
        // method and returning it
        return StreamUtils.nonClosing(in);
    }
}

