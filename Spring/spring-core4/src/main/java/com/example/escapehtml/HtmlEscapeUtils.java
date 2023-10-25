package com.example.escapehtml;

import com.google.common.html.HtmlEscapers;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.util.HtmlUtils;

// This class provides utility methods for HTML escaping.
public class HtmlEscapeUtils {
    // This method uses Apache Commons Lang to escape HTML characters in a string.
    public static String escapeWithApacheCommons(String input) {
        return StringEscapeUtils.escapeHtml4(input);
    }

    // This method uses Google Guava to escape HTML characters in a string.
    public static String escapeWithGuava(String input) {
        return HtmlEscapers.htmlEscaper().escape(input);
    }

    // This method uses Spring Framework to escape HTML characters in a string.
    public static String escapeWithSpring(String input) {
        return HtmlUtils.htmlEscape(input);
    }
}

