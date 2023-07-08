package org.example.crudServices;


import org.example.enitty.Client;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ClientCrudService {


    public void createClient(Client client) {
        Transaction transaction;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    public Client getById(long id) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateClient(Client client, Integer id) {
        Transaction transaction;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            client.setId(id);
            session.merge(client);
            transaction.commit();
        }
    }

    public void deleteById(Integer id) {
        Transaction transaction;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.remove(client);
                transaction.commit();
            }
        }
    }


}
