package jakartaee.examples.jpa.onetoone;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * The bean for the OneToOne annotation example.
 */
@Named @RequestScoped public class OneToOneBean implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private OneToOneEjb ejb;

    /**
     * Get the OneToOneA.
     *
     * @return the OneToOneA.
     */
    public OneToOneA getOneToOne() {
        return ejb.getOneToOneA();
    }
}
