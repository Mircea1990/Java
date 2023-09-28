package com.forest.ejb;

import java.util.List;

import com.forest.entity.OrderDetail;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless public class OrderDetailBean extends AbstractFacade<OrderDetail> {
    @PersistenceContext(unitName = "forestPU") private EntityManager em;

    public OrderDetailBean() {
        super(OrderDetail.class);
    }

    @Override protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Example of usage of NamedQuery
     *
     * @param orderId
     * @return
     */
    public List<OrderDetail> findOrderDetailByOrder(int orderId) {
        List<OrderDetail> details = getEntityManager().createNamedQuery("OrderDetail.findByOrderId")
                                                      .setParameter("orderId", orderId)
                                                      .getResultList();

        return details;
    }
}
