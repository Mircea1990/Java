package jakartaee.examples.faces.initparametermap;

import java.io.Serializable;
import java.util.Map;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.annotation.InitParameterMap;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * A request scoped bean injecting the init parameter map.
 */
@Named(value = "initParameterMapBean") @RequestScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3) public class InitParameterMapBean
        implements Serializable {

    /**
     * Stores the request cookie map.
     */
    @Inject @InitParameterMap private Map<String, String> initParameterMap;

    /**
     * Get the init parameter map.
     *
     * @return the init parametere map.
     */
    public Map<String, String> getInitParameterMap() {
        return initParameterMap;
    }
}
