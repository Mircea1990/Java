package jakartaee.examples.faces.sessionmap;

import java.io.Serializable;
import java.util.Map;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.annotation.SessionMap;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * A request scoped bean injecting the session map.
 */
@Named(value = "sessionMapBean") @RequestScoped @FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class SessionMapBean implements Serializable {

    /**
     * Stores the application map.
     */
    @Inject @SessionMap private Map<String, Object> sessionMap;

    /**
     * Get the view map.
     *
     * @return the view map.
     */
    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }
}
