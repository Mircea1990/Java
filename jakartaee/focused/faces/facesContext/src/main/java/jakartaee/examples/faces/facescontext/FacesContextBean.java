package jakartaee.examples.faces.facescontext;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * A request scoped bean injecting the FacesContext.
 */
@Named(value = "facesContextBean") @RequestScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3) public class FacesContextBean
        implements Serializable {

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
