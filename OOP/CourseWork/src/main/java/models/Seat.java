package models;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue
    @Column(name = "id_seat")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_train")
    private Train train;

    private int carriage;

    private int number;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getCarriage() {
        return carriage;
    }

    public void setCarriage(int carriage) {
        this.carriage = carriage;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Seat{" +
            "id=" + id +
            ", train=" + train +
            ", carriage=" + carriage +
            ", number=" + number +
            ", reservations=" + reservations +
            '}';
    }
}
