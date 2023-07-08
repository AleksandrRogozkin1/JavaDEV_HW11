package org.example.crudServices;

import org.example.enitty.Planet;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanetCrudService {
    public void createClient(Planet planet) {
        Transaction transaction;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    public Planet getById(long id) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateClient(Planet planet, int id) {
        Transaction transaction;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            planet.setId(id);
            session.merge(planet);
            transaction.commit();
        }
    }

    public void deleteById(int id) {
        Transaction transaction;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.remove(planet);
                transaction.commit();
            }
        }
    }

}
