package models;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue
    @Column(name = "id_reservation")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_seat")
    private Seat seat;

    private int start;

    private int end;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Reservation{" +
            "id=" + id +
            ", seat=" + seat +
            ", start=" + start +
            ", end=" + end +
            '}';
    }
}
