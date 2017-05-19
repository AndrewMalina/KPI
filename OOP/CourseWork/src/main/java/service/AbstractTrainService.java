package service;

import models.Train;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTrainService implements TrainService {
    @Override
    public List<Train> search() {
        List<Train> allTrains = getAllTrains();
        return allTrains;
    }

    abstract List<Train> getAllTrains();
}
