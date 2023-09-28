package com.forest.shipment.session;

import com.forest.entity.Customer;
import com.forest.entity.Person;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless public class UserBean extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "forestPU") private EntityManager em;

    public UserBean() {
        super(Customer.class);
    }

    @Override protected EntityManager getEntityManager() {
        return em;
    }

    public Person getUserByEmail(String email) {
        Query createNamedQuery = getEntityManager().createNamedQuery("Person.findByEmail");

        createNamedQuery.setParameter("email", email);

        return (Person) createNamedQuery.getSingleResult();
    }

}
