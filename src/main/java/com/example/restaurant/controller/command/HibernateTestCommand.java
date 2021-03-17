package com.example.restaurant.controller.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import com.example.restaurant.model.dao.TestEntityDao;
import com.example.restaurant.model.entity.TestEntity;

public class HibernateTestCommand implements Command {
    private static final Logger log = LoggerFactory.getLogger(DishRemoveCommand.class);

    public HibernateTestCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) throws Exception {

        TestEntityDao testEntityDao = new TestEntityDao();

        List<TestEntity> entities = testEntityDao.findAll();

        request.setAttribute("entities", entities);

        return "/WEB-INF/view/hibernateTest.jsp";
    }
}