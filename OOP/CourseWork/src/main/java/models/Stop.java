package models;

import com.sun.javafx.beans.IDProperty;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stops")
public class Stop {
    @Id
    @Column(name = "id_stop")
    private int id;

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
