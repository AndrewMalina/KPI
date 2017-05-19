package service;

import models.Ticket;

public abstract class AbstractTicketService implements TicketService {

    /*public Ticket Buy(Ticket seat, int start, int end, String name, String surname){
        return ;
    }*/

    public int getDistance(int start, int end) {
        return 0;
    }

    public int getPrice(Ticket ticket, int distance) {
        return 0;
    }
}
