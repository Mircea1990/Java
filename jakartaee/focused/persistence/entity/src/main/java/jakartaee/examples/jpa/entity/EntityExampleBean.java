package jakartaee.examples.jpa.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * The bean used to demonstrate usage of @Entity.
 */
@Named("entityExampleBean") @RequestScoped public class EntityExampleBean implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private EntityExampleEjb ejb;

    /**
     * Get the list of entities (instances of EntityExample).
     *
     * @return the list of entities.
     */
    public List<EntityExample> getEntities() {
        return ejb.getEntities();
    }
}
