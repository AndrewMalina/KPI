package service;

import models.Ticket;
import models.Train;

public interface TicketService {
    void buy(Ticket seat, String start, String end, String name, String surname);

    double getPrice(Train train, int start, int end);
}
