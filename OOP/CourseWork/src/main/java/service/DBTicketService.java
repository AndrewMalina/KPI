package service;

import models.Seat;
import models.Stop;
import models.Ticket;
import sample.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DBTicketService extends AbstractTicketService {
    @Override
    public void buy(List<Stop> stop, int start, int end, String name, String surname, String carriage, String number, String type, int id) {
        Ticket ticket = new Ticket();

        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();


        ticket.setName(name);
        ticket.setSurname(surname);
        ticket.setStart(start);
        ticket.setEnd(end);
        ticket.setSeat(seat(Integer.parseInt(carriage), Integer.parseInt(number), id));
        ticket.setDistance(getDistance(stop, start, end));
        ticket.setPrice(getPrice(ticket.getDistance(), type));



        em.getTransaction().begin();
        em.persist(ticket);
        em.getTransaction().commit();

        em.close();
    }

    public Seat seat(int carriage, int number, int id) {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();


        Query query = em.createQuery("from Seat");
        List resultList = query.getResultList();
        Seat seat = new Seat();

        for (Object seats : resultList) {
            if (carriage == ((Seat) seats).getCarriage() && number == ((Seat) seats).getNumber() && id == ((Seat) seats).getTrain().getId()) {
                seat = (Seat) seats;
            }

        }

        em.close();

        return seat;

    }
}
