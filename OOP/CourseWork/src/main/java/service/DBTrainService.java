package service;

import models.City;
import models.Train;
import sample.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DBTrainService extends AbstractTrainService {

    private static TrainService instance;

    public static TrainService getInstance() {
        if (instance == null) {
            instance = new DBTrainService();
        }
        return instance;
    }

    public DBTrainService() { }

    public List<City> getAllCity() {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();


        Query query = em.createQuery("from City");
        List resultList = query.getResultList();
        List<City> cities = new ArrayList<>();

        for (Object city : resultList) {
            cities.add((City) city);
        }

        em.close();

        return cities;

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
        return trains;
    }
}
