package jakartaee.examples.faces.viewmap;

import java.io.Serializable;
import java.util.Map;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.annotation.ViewMap;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * A request scoped bean injecting the view map.
 */
@Named(value = "viewMapBean") @RequestScoped @FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class ViewMapBean implements Serializable {

    /**
     * Stores the application map.
     */
    @Inject @ViewMap private Map<String, Object> viewMap;

    /**
     * Get the view map.
     *
     * @return the view map.
     */
    public Map<String, Object> getViewMap() {
        return viewMap;
    }
}
