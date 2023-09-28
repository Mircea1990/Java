package com.forest.ejb;

import java.io.Serializable;

import com.forest.entity.OrderStatus;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless public class OrderStatusBean extends AbstractFacade<OrderStatus>
        implements Serializable {

    private static final long serialVersionUID = 5199196331433553237L;
    @PersistenceContext(unitName = "forestPU") private EntityManager em;

    public OrderStatusBean() {
        super(OrderStatus.class);
    }

    @Override protected EntityManager getEntityManager() {
        return em;
    }

    public OrderStatus getStatusByName(String status) {
        Query createNamedQuery = getEntityManager().createNamedQuery("OrderStatus.findByStatus");

        //SELECT o FROM OrderStatus o WHERE o.status = :status
        createNamedQuery.setParameter("status", status);

        return (OrderStatus) createNamedQuery.getSingleResult();
    }
}
