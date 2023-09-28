package jakartaee.examples.faces.managedconverter;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;

/**
 * The managed bean for the CDI managed converter example..
 */
@Named @RequestScoped @FacesConfig(version = FacesConfig.Version.JSF_2_3)
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
