package jakartaee.examples.faces.managedconverter;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;

/**
 * The managed bean for the CDI managed converter example..
 */
@Named @RequestScoped @FacesConfig
public class ManagedConverterBean {

    /**
     * Stores the value.
     */
    private Object value = "1";

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
