package jakartaee.examples.jpa.onetoone;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * The EJB for the OneToOne annotation example..
 */
@Stateless public class OneToOneEjb {

    /**
     * Stores the persistence context.
     */
    @PersistenceContext(unitName = "persistenceContextPU") private EntityManager em;

    /**
     * Get the OneToOneA.
     *
     * @return the OneToOneA.
     */
    public OneToOneA getOneToOneA() {
        OneToOneA result = null;
        List<OneToOneA> list = em.createQuery("SELECT object(e) FROM OneToOneA AS e",
                                              OneToOneA.class).getResultList();
        if (list.isEmpty()) {
            OneToOneA a = new OneToOneA();
            a.setId(1L);
            OneToOneB b = new OneToOneB();
            b.setId(1L);
            a.setB(b);
            em.persist(a);
            list = em.createQuery("SELECT object(e) FROM OneToOneA AS e", OneToOneA.class)
                     .getResultList();
        }
        if (!list.isEmpty()) {
            result = list.get(0);
        }
        return result;
    }
}
