package com.example.restaurant.model.dao;

import com.example.restaurant.model.entity.TestEntity;
import com.example.restaurant.utils.HibernateSessionFactoryUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;

public class TestEntityDao {
    public TestEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TestEntity.class, id);
    }

    public void save(TestEntity test) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            Transaction tx1 = session.beginTransaction();
            session.save(test);
            tx1.commit();
        }
        catch ( Exception e ) {
            if ( session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK ) {
                session.getTransaction().rollback();
            }
        }
        finally {
            session.close();
        }
    }

    public void update(TestEntity test) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        try {
            Transaction tx1 = session.beginTransaction();
            session.update(test);
            tx1.commit();
        }
        catch ( Exception e ) {
            if ( session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK ) {
                session.getTransaction().rollback();
            }
        }
        finally {
            session.close();
        }
    }

    public void delete(TestEntity test) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        try {
            Transaction tx1 = session.beginTransaction();
            session.delete(test);
            tx1.commit();
        }
        catch ( Exception e ) {
            if ( session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK ) {
                session.getTransaction().rollback();
            }
        }
        finally {
            session.close();
        }
    }

    public List<TestEntity> findAll() {
        List<TestEntity> tests = (List<TestEntity>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From TestEntity").list();
        return tests;
    }
}
