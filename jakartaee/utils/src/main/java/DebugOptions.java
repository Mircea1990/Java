package src.main.java;

import com.gargoylesoftware.htmlunit.WebClient;

/*
DebugOptions class provides a utility method called setDebugOptions that is used to configure
debugging options for a WebClient instance from the HtmlUnit library.
 */
public class DebugOptions {

    /*
    This method accepts a WebClient instance as a parameter and is responsible for setting the
    debugging options for that instance.
     */
    public static void setDebugOptions(WebClient webClient) {
        /*
        This line checks if the system property named "suspend" is set. The System.getProperty
        method retrieves the value of the specified system property, and if it is not null, it
        indicates that debugging should be enabled.
         */
        if (System.getProperty("suspend") != null) {
            /*
            If the "suspend" property is set, this line sets the timeout of the WebClient
            instance to 0, effectively disabling the timeout. This allows the execution to be
            paused indefinitely, providing an opportunity for debugging and inspecting the state
            of the web page during integration testing.
             */
            webClient.getOptions().setTimeout(0);
        }
    }

}
