import models.Seat;
import models.Train;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Train t = new Train();
        t.setName("");
        t.setType("Day");
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 20; j++) {
                Seat s = new Seat();
                s.setTrain(t);
                s.setCarriage(i);
                s.setNumber(j);

                t.addSeat(s);
            }
        }
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
