package jakartaee.examples.faces.sessionmap;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.annotation.SessionMap;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Map;

/**
 * A request scoped bean injecting the session map.
 */
@Named(value = "sessionMapBean") @RequestScoped @FacesConfig
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
