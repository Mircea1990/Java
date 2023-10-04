package jakartaee.examples.faces.managedproperty;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

/**
 * A bean using a managed property.
 */
@Named(value = "managedPropertyBean") @RequestScoped
@FacesConfig public class ManagedPropertyBean
        implements Serializable {

    /**
     * Stores the context path using a managed property.
     */
    @Inject @ManagedProperty(value = "#{externalContext.requestContextPath}") private String
            contextPath;

    /**
     * Get the context path.
     *
     * @return the context path.
     */
    public String getContextPath() {
        return contextPath;
    }
}
