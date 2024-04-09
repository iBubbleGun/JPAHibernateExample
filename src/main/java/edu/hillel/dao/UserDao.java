package edu.hillel.dao;

import edu.hillel.models.Auto;
import edu.hillel.models.User;
import edu.hillel.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao {

    public List<User> findAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("From User", User.class).list();
        }
    }

    public User findById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        }
    }

    public void save(User user) {
        final Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        final Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        final Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        final Transaction transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        final Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        final Transaction transaction = session.beginTransaction();
        session.remove(user);
        transaction.commit();
        session.close();
    }

    public Auto findAutoById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Auto.class, id);
        }
    }
}
