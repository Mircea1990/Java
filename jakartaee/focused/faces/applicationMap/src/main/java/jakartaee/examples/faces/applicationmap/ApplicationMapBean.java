package main.java.jakartaee.examples.faces.applicationmap;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ApplicationMap;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Map;

/**
 * A request scoped bean for the injected ApplicationMap example.
 */
@Named(value = "applicationMapBean") @RequestScoped
@FacesConfig public class ApplicationMapBean
        implements Serializable {

    /**
     * Stores the application map.
     */
    @Inject @ApplicationMap private final transient Map<String, Object> applicationMap;

    public ApplicationMapBean(Map<String, Object> applicationMap) {
        this.applicationMap = applicationMap;
    }

    /**
     * Get the application map.
     *
     * @return the application map.
     */
    public Map<String, Object> getApplicationMap() {
        return applicationMap;
    }
}
