package com.forest.ejb;

import com.forest.entity.Groups;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless public class GroupsBean extends AbstractFacade<Groups> {
    @PersistenceContext(unitName = "forestPU") private EntityManager em;

    public GroupsBean() {
        super(Groups.class);
    }

    @Override protected EntityManager getEntityManager() {
        return em;
    }

}
