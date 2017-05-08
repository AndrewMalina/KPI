package models;

import com.sun.javafx.beans.IDProperty;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stops")
public class Stop {
    @Id
    private int id;
    private int city;
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
