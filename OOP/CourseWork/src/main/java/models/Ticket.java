package models;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue
    @Column(name = "id_ticket")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_train")
    private Seat seat;

    private int start;

    private int end;

    private double price;

    private String name;

    private String surname;

    private int distance;

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
            "id=" + id +
            ", seat=" + seat +
            ", start=" + start +
            ", end=" + end +
            ", price=" + price +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", distance=" + distance +
            '}';
    }
}
