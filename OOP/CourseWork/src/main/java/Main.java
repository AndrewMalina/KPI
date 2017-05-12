import models.Seat;
import models.Train;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Train t = new Train();
        t.setName("Test Train");

        Seat s = new Seat();
        s.setTrain(t);
        s.setCarriage(4);
        s.setNumber(34);

        t.addSeat(s);


        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();


        Query query = em.createQuery("from Train where name = :name");
        query.setParameter("name", "Test Train");
        List resultList = query.getResultList();
        Train train = (Train) resultList.get(0);

        System.out.println(train);
        em.close();
        PersistenceManager.INSTANCE.close();
    }
}
