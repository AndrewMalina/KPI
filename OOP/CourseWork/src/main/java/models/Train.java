package models;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private String id;
    private String name;
    private String type;
    private List<Stop> stops = new ArrayList<Stop>();
    private List<Seat> seats = new ArrayList<Seat>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
