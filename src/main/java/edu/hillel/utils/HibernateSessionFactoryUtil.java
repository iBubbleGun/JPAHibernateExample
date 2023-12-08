package edu.hillel.utils;

import edu.hillel.models.Auto;
import edu.hillel.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateSessionFactoryUtil {

    private static final Logger LOG = LoggerFactory.getLogger(HibernateSessionFactoryUtil.class);
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                final Configuration config = new Configuration().configure();
                config.addAnnotatedClass(User.class);
                config.addAnnotatedClass(Auto.class);

                final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
                sessionFactory = config.buildSessionFactory(builder.build());
                LOG.debug("Successfully initialising SessionFactory.");
            } catch (Exception e) {
                LOG.error("An error occurred while trying to get the SessionFactory!", e);
            }
        }
        LOG.debug("Successfully returned SessionFactory.");
        return sessionFactory;
    }
}
