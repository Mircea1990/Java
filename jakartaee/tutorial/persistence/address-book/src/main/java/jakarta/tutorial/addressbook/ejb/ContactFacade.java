package jakarta.tutorial.addressbook.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.tutorial.addressbook.entity.Contact;


@Stateless public class ContactFacade extends AbstractFacade<Contact> {
    @PersistenceContext(unitName = "address-bookPU") private EntityManager em;

    public ContactFacade() {
        super(Contact.class);
    }

    @Override protected EntityManager getEntityManager() {
        return em;
    }

}
