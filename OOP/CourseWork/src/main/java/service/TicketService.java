package service;

import models.Ticket;

public interface TicketService {
    Ticket Buy(Ticket seat, int start, int end, String name, String surname);
    int getDistance(int start, int end);
    int getPrice(Ticket ticket, int distance);
}
