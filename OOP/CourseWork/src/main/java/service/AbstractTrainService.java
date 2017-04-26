package service;

import models.Train;

import java.util.Date;
import java.util.List;

public abstract class AbstractTrainService implements TrainService{
   /* public List<Train> search(int start, int end, Date date){
        return List<>;
    }*/
    abstract List<Train> getAllTrains();
}
