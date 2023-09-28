package jakartaee.examples.jpa.persistenceContext;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * A simple EJB that gives access to the list of rows.
 */
@Stateless public class PersistenceContextEjb {

    /**
     * Stores the persistence context.
     */
    @PersistenceContext(unitName = "persistenceContextPU") private EntityManager em;

    /**
     * Get the list of entities.
     *
     * @return the list of entities.
     */
    public List<PersistenceContextRow> getRows() {
        return em.createQuery("SELECT object(e) FROM PersistenceContextRow AS e",
                              PersistenceContextRow.class).getResultList();
    }
}
