package jakartaee.examples.jpa.resultstream;

import java.util.List;
import java.util.stream.Stream;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * The EJB for the createQuery example.
 */
@Stateless public class ResultStreamEjb {

    /**
     * Stores the persistence context.
     */
    @PersistenceContext private EntityManager em;

    /**
     * Get all the rows.
     *
     * @return all the rows.
     */
    public Stream<ResultStreamRow> getRows() {
        List<ResultStreamRow> list = em.createQuery("SELECT object(r) FROM ResultStreamRow AS r",
                                                    ResultStreamRow.class).getResultList();
        if (list.isEmpty()) {
            ResultStreamRow row = new ResultStreamRow();
            row.setId(1L);
            em.persist(row);
            row = new ResultStreamRow();
            row.setId(2L);
            em.persist(row);
        }
        return em.createQuery("SELECT object(r) FROM ResultStreamRow AS r", ResultStreamRow.class)
                 .getResultStream();
    }
}
