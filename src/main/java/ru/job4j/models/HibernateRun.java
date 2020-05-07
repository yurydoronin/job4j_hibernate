package ru.job4j.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class HibernateRun.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 07.05.2020
 */
public class HibernateRun {

    private static final Logger LOG = LoggerFactory.getLogger(HibernateRun.class);

    private static SessionFactory factory;
    private static Session session;

    protected static void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = factory.openSession();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private static void add(User user) {
        user.setName(user.getName());
        user.setExpired(LocalDateTime.now());
        session.saveOrUpdate(user);
        System.out.println(session.createQuery("from User").list());
        System.out.println("");
    }

    private static void update(User user) {
        user.setId(user.getId());
        user.setName(user.getName());
        user.setExpired(LocalDateTime.now());
        session.saveOrUpdate(user);
        System.out.println(session.createQuery("from User").list());
        System.out.println("");
    }

    private static void delete(User user) {
        user.setId(user.getId());
        session.delete(user);
    }

    private static void showAll() {
        List<User> users = session.createQuery("from User").list();
        users.forEach(System.out::println);
    }

    public static void main(String[] args) {
        HibernateRun.setUp();
        session.beginTransaction();

        User user1 = new User();
        user1.setName("Коля");
        HibernateRun.add(user1);

        user1.setName("Маша");
        HibernateRun.update(user1);

        user1.setId(1);
        HibernateRun.delete(user1);

        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        user2.setName("Настя");
        user3.setName("Вася");
        user4.setName("Даша");
        HibernateRun.add(user2);
        HibernateRun.add(user3);
        HibernateRun.add(user4);
        HibernateRun.showAll();

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
