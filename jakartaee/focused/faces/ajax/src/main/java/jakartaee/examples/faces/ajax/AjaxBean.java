package jakartaee.examples.faces.ajax;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * A request scoped bean for the f:ajax example.
 */
@Named @RequestScoped public class AjaxBean {

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
        outputText = "And you just submitted the form using f:ajax";
        return "";
    }
}
