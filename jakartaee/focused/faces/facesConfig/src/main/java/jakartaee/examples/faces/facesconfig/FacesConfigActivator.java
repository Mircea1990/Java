package jakartaee.examples.faces.facesconfig;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;

import java.io.Serializable;

/**
 * An application scoped bean activating JSF 2.3 mode.
 */
@ApplicationScoped @FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class FacesConfigActivator implements Serializable {}
