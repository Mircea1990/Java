package jakartaee.examples.faces.commandscript;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

/**
 * A request scoped bean for the h:commandScript example.
 */
@Named(value = "commandScriptBean") @RequestScoped public class CommandScriptBean
        implements Serializable {

    /**
     * Stores the output.
     */
    private String output;

    /**
     * Get the output.
     *
     * @return the output.
     */
    public String getOutput() {
        return output;
    }

    /**
     * Process the call.
     *
     * @return null
     */
    public Object process() {
        output = "And we processed the call";
        return null;
    }
}
