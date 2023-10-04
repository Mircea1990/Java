package jakartaee.examples.faces.csrf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * A request scoped bean for the CSRF example.
 */
@Named @RequestScoped public class CsrfBean {

    /**
     * Stores the output text.
     */
    private String outputText = "'Hello World'";

    /**
     * Get the outputText.
     *
     * @return the outputText.
     */
    public String getOutputText() {
        return outputText;
    }

    /**
     * Set the outputText.
     *
     * @param outputText the outputText.
     */
    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }

    /**
     * Submit the form.
     *
     * @return ""
     */
    public String submit() {
        outputText = "And you just submitted the form";
        return "";
    }
}
