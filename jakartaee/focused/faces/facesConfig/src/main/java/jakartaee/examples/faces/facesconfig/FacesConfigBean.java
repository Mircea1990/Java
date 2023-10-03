package jakartaee.examples.faces.facesconfig;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

/**
 * A request scoped bean
 */
@Named(value = "facesConfigBean") @RequestScoped @FacesConfig
public class FacesConfigBean implements Serializable {

    /**
     * Stores the FacesContext.
     */
    @Inject private FacesContext facesContext;

    /**
     * Get the FacesContext.
     *
     * @return the FacesContext.
     */
    public FacesContext getFacesContext() {
        return facesContext;
    }
}
