package com.baeldung.escapehtml;

import com.example.escapehtml.HtmlEscapeUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// This is a test class for HTML escape utilities
public class HtmlEscapeUnitTest {

    // This test checks if the ampersand character is properly escaped
    @Test public void whenInputContainAmpersand_thenEscape() {
        // The input string contains an ampersand
        String input = "AT&T";
        // The expected output after escaping the ampersand
        String expected = "AT&T";
        // Assert that the output of each escape method matches the expected output
        assertEquals(expected, HtmlEscapeUtils.escapeWithApacheCommons(input));
        assertEquals(expected, HtmlEscapeUtils.escapeWithGuava(input));
        assertEquals(expected, HtmlEscapeUtils.escapeWithSpring(input));
    }

    // This test checks if double quotes are properly escaped
    @Test public void whenInputContainDoubleQuotes_thenEscape() {
        // The input string contains double quotes
        String input = "She said, Hello!";
        // The expected output after escaping the double quotes
        String expected = "She said, Hello!";
        // Assert that the output of each escape method matches the expected output
        assertEquals(expected, HtmlEscapeUtils.escapeWithApacheCommons(input));
        assertEquals(expected, HtmlEscapeUtils.escapeWithGuava(input));
        assertEquals(expected, HtmlEscapeUtils.escapeWithSpring(input));
    }

    // This test checks if various HTML symbols are properly escaped
    @Test public void whenInputContainManyHtmlSymbols_thenEscape() {
        // The input string contains various HTML symbols
        String input = "<p>This is a <strong>test</strong> string.</p>";
        // The expected output after escaping the HTML symbols
        String expected = "<p>This is a <strong>test</strong> string.</p>";
        // Assert that the output of each escape method matches the expected output
        assertEquals(expected, HtmlEscapeUtils.escapeWithApacheCommons(input));
        assertEquals(expected, HtmlEscapeUtils.escapeWithGuava(input));
        assertEquals(expected, HtmlEscapeUtils.escapeWithSpring(input));
    }

    // This test checks if a plain text without any HTML symbols remains unchanged after escaping
    @Test public void whenInputContainNoHtmlSymbols_thenEscape() {
        // The input string does not contain any HTML symbols
        String input = "This is a plain text.";
        // Assert that the output of each escape method matches the input as there are no HTML
        // symbols to escape
        assertEquals(input, HtmlEscapeUtils.escapeWithApacheCommons(input));
        assertEquals(input, HtmlEscapeUtils.escapeWithGuava(input));
        assertEquals(input, HtmlEscapeUtils.escapeWithSpring(input));
    }
}

