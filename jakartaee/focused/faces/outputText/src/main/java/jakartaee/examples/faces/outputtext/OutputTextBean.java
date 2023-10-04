package jakartaee.examples.faces.outputtext;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * A request scoped bean for the h:outputText example.
 */
@Named @RequestScoped public class OutputTextBean {

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
}
