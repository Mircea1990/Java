package jakartaee.examples.faces.requestcookiemap;

import java.io.Serializable;
import java.util.Map;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.annotation.RequestCookieMap;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * A request scoped bean injecting the request cookie map.
 */
@Named(value = "requestCookieMapBean") @RequestScoped
@FacesConfig public class RequestCookieMapBean
        implements Serializable {

    /**
     * Stores the request cookie map.
     */
    @Inject @RequestCookieMap private Map<String, Object> requestCookieMap;

    /**
     * Get the request cookie map.
     *
     * @return the request cookie map.
     */
    public Map<String, Object> getRequestCookieMap() {
        return requestCookieMap;
    }
}
