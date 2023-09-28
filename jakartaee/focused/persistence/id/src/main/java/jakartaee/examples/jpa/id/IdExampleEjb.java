package jakartaee.examples.jpa.id;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * A simple EJB that gives access to the list of objects.
 */
@Stateless public class IdExampleEjb {

    /**
     * Stores the persistence context.
     */
    @PersistenceContext private EntityManager em;

    /**
     * Get the list of objects.
     *
     * @return the list of object.
     */
    public List<IdExample> getObjects() {
        return em.createQuery("SELECT object(i) FROM IdExample AS i", IdExample.class)
                 .getResultList();
    }
}
