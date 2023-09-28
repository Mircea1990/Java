package jakartaee.examples.jpa.entity;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * A simple EJB that gives access to the list of entities.
 */
@Stateless public class EntityExampleEjb {

    /**
     * Stores the persistence context.
     */
    @PersistenceContext private EntityManager em;

    /**
     * Get the list of entities.
     *
     * @return the list of entities.
     */
    public List<EntityExample> getEntities() {
        return em.createQuery("SELECT object(e) FROM EntityExample AS e", EntityExample.class)
                 .getResultList();
    }
}
