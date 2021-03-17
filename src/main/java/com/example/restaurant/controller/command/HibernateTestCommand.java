package com.example.restaurant.controller.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.example.restaurant.controller.EJB.TestEntityService;
import com.example.restaurant.model.dao.TestEntityDao;
import com.example.restaurant.model.entity.TestEntity;

public class HibernateTestCommand implements Command {

    private TestEntityService _service;
    private Random rand = new Random();
    
    public HibernateTestCommand(TestEntityService service) {
        this._service = service;
    }

    @Override
    public String execute(HttpServletRequest request) throws Exception {

        TestEntityDao testEntityDao = new TestEntityDao();

        List<TestEntity> entities = testEntityDao.findAll();

        request.setAttribute("entities", entities);

        TestEntity entity = new TestEntity();

        entity.setName("TEST" + rand.nextInt(100));

        this._service.create(entity);

        return "/WEB-INF/view/hibernateTest.jsp";
    }
}