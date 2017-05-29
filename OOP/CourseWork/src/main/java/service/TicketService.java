package service;

import models.Stop;
import models.Ticket;
import models.Train;

import java.util.List;

public interface TicketService {
    void buy(List<Stop> stop, int start, int end, String name, String surname, String carriage, String number, String type,int id);

    double getPrice(int distance, String type);

    int getDistance(List<Stop> stop, int start, int end);
}
