package models;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "trains")
public class Train {
    @Id
    @GeneratedValue
    @Column(name = "id_train")
    private Integer id;

    private String name;

    private String type;

    @OneToMany(mappedBy = "train", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Stop> stops;

    @OneToMany(mappedBy = "train", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Seat> seats;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Train{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", stops=" + stops +
            ", seats=" + seats +
            '}';
    }
}
