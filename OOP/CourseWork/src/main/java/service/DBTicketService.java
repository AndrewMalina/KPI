package service;

import sample.PersistenceManager;
import models.Ticket;

import javax.persistence.EntityManager;

public class DBTicketService extends AbstractTicketService{
    @Override
    public void buy(Ticket ticket, String start, String end, String name, String surname) {
        ticket = new Ticket();
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        DBTrainService search = new DBTrainService();
        ticket.setName(name);
        ticket.setSurname(surname);
        ticket.setStart(search.searchCity(start,end).get(0));
        ticket.setEnd(search.searchCity(start,end).get(1));
        //ticket.setSeat();
        //ticket.setPrice(getPrice(,search.searchCity(start,end).get(0),search.searchCity(start,end).get(1)));

        em.getTransaction().begin();
        em.persist(ticket);
        em.getTransaction().commit();

        em.close();
    }
}
