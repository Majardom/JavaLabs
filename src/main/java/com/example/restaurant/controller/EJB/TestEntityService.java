package com.example.restaurant.controller.EJB;

import javax.ejb.Stateless;

import com.example.restaurant.model.dao.TestEntityDao;
import com.example.restaurant.model.entity.TestEntity;

@Stateless
public class TestEntityService {
    private TestEntityDao testEntityDao = new TestEntityDao();

    public void create(TestEntity entity) {
        testEntityDao.save(entity);
    }
}
