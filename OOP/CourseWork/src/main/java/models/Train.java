package models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trains")
public class Train {
    @Id
    @GeneratedValue
    @Column(name = "id_train")
    private String id;

    @Column(name = "name_train")
    private String name;

    @Column(name = "type_train")
    private String type;

    @OneToMany(mappedBy = "id_train")
    private List<Stop> stops;

    @OneToMany(mappedBy = "id_train")
    private List<Seat> seats;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
