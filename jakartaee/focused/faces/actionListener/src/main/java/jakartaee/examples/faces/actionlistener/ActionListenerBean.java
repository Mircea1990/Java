package jakartaee.examples.faces.actionlistener;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * The bean for the f:actionListener example.
 */
@Named @RequestScoped public class ActionListenerBean {

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
