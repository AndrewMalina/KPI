import models.Seat;
import models.Train;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Train t = new Train();
        t.setName("Test Train");
        Seat s = new Seat();
        s.setNumber(4);
        s.setCarriage(5);

        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();

        em = PersistenceManager.INSTANCE.getEntityManager();
        Train train = em.find(Train.class, 1);
        s.setTrain(train);
        em.persist(s);
        em.close();

        em = PersistenceManager.INSTANCE.getEntityManager();
        train = em.find(Train.class, 1);

        System.out.println(train);
        em.close();
        PersistenceManager.INSTANCE.close();
    }
}
