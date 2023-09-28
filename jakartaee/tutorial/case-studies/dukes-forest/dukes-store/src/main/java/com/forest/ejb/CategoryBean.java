package com.forest.ejb;

import com.forest.entity.Category;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless public class CategoryBean extends AbstractFacade<Category> {
    @PersistenceContext(unitName = "forestPU") private EntityManager em;

    public CategoryBean() {
        super(Category.class);
    }

    @Override protected EntityManager getEntityManager() {
        return em;
    }

}
