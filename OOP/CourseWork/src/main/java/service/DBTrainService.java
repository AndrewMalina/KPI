package service;

import manager.PersistenceManager;
import models.City;
import models.Train;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBTrainService extends AbstractTrainService{


    List<City> getAllCity() {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();


        Query query = em.createQuery("from City");
        List resultList = query.getResultList();
        List<City> city = new ArrayList<>();

        for (Object train : resultList) {
            city.add((City) city);
        }

        em.close();
        PersistenceManager.INSTANCE.close();
        return city;

    }

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
