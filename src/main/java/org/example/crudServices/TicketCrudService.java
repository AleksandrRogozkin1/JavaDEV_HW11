package org.example.crudServices;


import org.example.enitty.Ticket;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TicketCrudService {

    public void createTicket(Ticket ticket) {
        Transaction transaction;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    public Ticket getById(long id) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        } catch (Exception e) {
            System.out.println("Invalid id");
            return null;

        }
    }

    public void updateTicket(Ticket ticket, Integer id) {
        Transaction transaction;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ticket.setId(id);
            session.merge(ticket);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Invalid id");
        }
    }

    public void deleteById(Integer id) {
        Transaction transaction;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.remove(ticket);
                transaction.commit();
            }
        } catch (Exception e) {
            System.out.println("Invalid id");
        }
    }
}
