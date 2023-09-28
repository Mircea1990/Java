package jakartaee.examples.faces.externalcontext;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.context.ExternalContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

/**
 * A request scoped bean injecting the ExternalContext.
 */
@Named(value = "externalContextBean") @RequestScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3) public class ExternalContextBean
        implements Serializable {

    /**
     * Stores the ExternalContext.
     */
    @Inject private ExternalContext externalContext;

    /**
     * Get the ExternalContext.
     *
     * @return the ExternalContext.
     */
    public ExternalContext getExternalContext() {
        return externalContext;
    }
}
