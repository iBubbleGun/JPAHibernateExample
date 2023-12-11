package edu.hillel.DAO;

import edu.hillel.models.Auto;
import edu.hillel.models.User;
import edu.hillel.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao {

    public List<User> findAll() {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From User", User.class)
                .list();
    }

    public User findById(int id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(User.class, id);
    }

    public void save(User user) {
        final Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        final Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        final Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        final Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        final Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        final Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(Auto.class, id);
    }
}
