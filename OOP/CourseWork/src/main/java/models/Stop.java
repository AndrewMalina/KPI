package models;

import com.sun.javafx.beans.IDProperty;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "stops")
public class Stop {
    @Id
    @GeneratedValue
    @Column(name = "id_stop")
    private int id;

    @Column(name = "train_id")
    private int train_id;

    @Column(name = "city_stop")
    private int city;

    @Column(name = "date_stop")
    private Date date;

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
}
