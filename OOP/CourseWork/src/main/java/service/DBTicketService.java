package service;

import models.Reservation;
import models.Seat;
import models.Stop;
import models.Ticket;
import sample.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
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

        Reservation reservation = new Reservation();

        reservation.setStart(start);
        reservation.setEnd(end);
        reservation.setSeat(seat(Integer.parseInt(carriage), Integer.parseInt(number), id));

        em.getTransaction().begin();
        em.persist(reservation);
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

    public boolean reservation(int start, int end, String carriageText, String placeText, Integer id) {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();


        Query query = em.createQuery("from Reservation ");
        List resultList = query.getResultList();

        boolean answer = true;

        List<Integer> listStop = new ArrayList<>();
        boolean startBool = false;
        for (Object reservation : resultList) {
            if (((Reservation) reservation).
                    getSeat().
                    getTrain().
                    getId().equals(id)) {
                if (((Reservation) reservation).
                        getSeat().
                        getCarriage() == Integer.parseInt(carriageText) && ((Reservation) reservation).
                        getSeat().
                        getNumber() == Integer.parseInt(placeText)) {
                    for (Object stop : ((Reservation) reservation).getSeat().getTrain().getStops()) {
                        if (((Stop) stop).getCity() == start || startBool){
                            startBool = true;
                            listStop.add(((Stop) stop).getCity());
                            if (((Stop) stop).getCity() == end){
                                break;
                            }
                        }
                    }
                    for (int i : listStop) {
                        if (i == ((Reservation) reservation).getStart() || i ==((Reservation) reservation).getEnd()){
                            answer = false;
                        }
                    }
                }
            }
        }
        em.close();

        return answer;

    }
}
