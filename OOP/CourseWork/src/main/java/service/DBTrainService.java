package service;

import manager.PersistenceManager;
import models.Train;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBTrainService extends AbstractTrainService{


    List<Train> getAllTrains() {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();


        Query query = em.createQuery("from Train");
        List resultList = query.getResultList();
        List<Train> trains = new ArrayList<>();

        for (Object train : resultList) {
            trains.add((Train) train);
        }

        em.close();
        PersistenceManager.INSTANCE.close();
        return trains;
    }


}
