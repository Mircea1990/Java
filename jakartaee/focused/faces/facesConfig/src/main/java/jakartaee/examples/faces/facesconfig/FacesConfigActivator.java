package jakartaee.examples.faces.facesconfig;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;

import java.io.Serializable;

/**
 * An application scoped bean
 */
@ApplicationScoped @FacesConfig
public class FacesConfigActivator implements Serializable {}
