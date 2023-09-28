package jakartaee.examples.jpa.onetomany;

import java.util.HashSet;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * The EJB for the OneToMany annotation example..
 */
@Stateless public class OneToManyEjb {

    /**
     * Stores the persistence context.
     */
    @PersistenceContext(unitName = "persistenceContextPU") private EntityManager em;

    /**
     * Get the OneToManyA.
     *
     * @return the OneToManyA.
     */
    public OneToManyA getOneToManyA() {
        OneToManyA result = null;
        List<OneToManyA> list = em.createQuery("SELECT object(e) FROM OneToManyA AS e",
                                               OneToManyA.class).getResultList();
        if (list.isEmpty()) {
            OneToManyA a = new OneToManyA();
            a.setId(1L);
            HashSet set = new HashSet();
            OneToManyB b = new OneToManyB();
            b.setA(a);
            b.setId(1L);
            set.add(b);
            a.setBs(set);
            em.persist(a);
            list = em.createQuery("SELECT object(e) FROM OneToManyA AS e", OneToManyA.class)
                     .getResultList();
        }
        if (!list.isEmpty()) {
            result = list.get(0);
        }
        return result;
    }
}
