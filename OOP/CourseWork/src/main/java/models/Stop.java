package models;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "stops")
public class Stop {
    @Id
    @GeneratedValue
    @Column(name = "id_stop")
    private Integer id;

    @Column(name = "city")
    private int city;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_train")
    private Train train;

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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

    @Override
    public String toString() {
        return "Stop{" +
            "id=" + id +
            ", city=" + city +
            ", date=" + date +
            ", train=" + train +
            '}';
    }
}
