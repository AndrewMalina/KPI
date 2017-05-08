package models;

import com.sun.javafx.beans.IDProperty;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seat")
public class Seat {
    @Id
    private Train train = new Train();
    private int carriage;
    private int number;
    private List<Reservation> reservations = new ArrayList<Reservation>();

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
}
