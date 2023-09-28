package jakartaee.examples.jpa.onetomany;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * The bean for the OneToMany annotation example.
 */
@Named @RequestScoped public class OneToManyBean implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private OneToManyEjb ejb;

    /**
     * Get the OneToManyA.
     *
     * @return the OneToManyA.
     */
    public OneToManyA getOneToMany() {
        return ejb.getOneToManyA();
    }
}
