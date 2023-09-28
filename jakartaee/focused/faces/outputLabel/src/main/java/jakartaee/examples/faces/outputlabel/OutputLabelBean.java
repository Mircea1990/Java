package jakartaee.examples.faces.outputlabel;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 * A request scoped bean for the h:outputLabel example.
 */
@Named @RequestScoped public class OutputLabelBean {

    /**
     * Stores the output text.
     */
    private String outputLabel = "'Hello World'";

    /**
     * Get the output label.
     *
     * @return the output label.
     */
    public String getOutputLabel() {
        return outputLabel;
    }

    /**
     * Set the output label.
     *
     * @param outputLabel the output label.
     */
    public void setOutputLabel(String outputLabel) {
        this.outputLabel = outputLabel;
    }
}
