package jakartaee.examples.utils;

import com.gargoylesoftware.htmlunit.WebClient;

public class DebugOptions {

    public static void setDebugOptions(WebClient webClient) {
        if (System.getProperty("suspend") != null) {
            webClient.getOptions().setTimeout(0);
        }
    }

}
