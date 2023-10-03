package jakartaee.examples.faces.managedvalidator;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;

/**
 * The bean for the CDI managed validator example.
 */
@Named @RequestScoped @FacesConfig
public class ManagedValidatorBean {

    /**
     * Stores the value.
     */
    private Object value = "A value";

    /**
     * Get the value.
     *
     * @return the value.
     */
    public Object getValue() {
        return value;
    }

    /**
     * Set the value.
     *
     * @param value the value.
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Submit.
     *
     * @return ""
     */
    public String submit() {
        return "";
    }
}
