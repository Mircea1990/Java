package jakartaee.examples.jpa.createquery;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * The EJB for the createQuery example.
 */
@Stateless public class CreateQueryEjb {

    /**
     * Stores the persistence context.
     */
    @PersistenceContext private EntityManager em;

    /**
     * Get all the rows.
     *
     * @return all the rows.
     */
    public List<CreateQueryRow> getRows() {
        return em.createQuery("SELECT object(r) FROM CreateQueryRow AS r", CreateQueryRow.class)
                 .getResultList();
    }
}
