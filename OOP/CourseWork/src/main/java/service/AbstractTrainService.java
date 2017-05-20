package service;

import models.City;
import models.Train;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTrainService implements TrainService {
    @Override
    public List<Train> search(String start,String end) {
        List<Train> allTrains = getAllTrains();
        List<City> allCity = getAllCity();

        return allTrains;
    }

    abstract List<Train> getAllTrains();
    abstract List<City> getAllCity();
}
