package service;

import models.City;
import models.Train;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTrainService implements TrainService {
    @Override
    public List<Integer> searchCity(String start, String end){
        List<City> allCity = getAllCity();
        List<Integer> startEnd = new ArrayList<>();

        for (City count : allCity) {
            if (start.equals(count.getId())) {
                startEnd.add(count.getId());
            }
            if (end.equals(count.getId())) {
                startEnd.add(count.getId());
            }
        }
        return startEnd;
    }
    @Override
    public List<Train> search(String start, String end) {

        List<Train> allTrains = getAllTrains();

        int startInt = searchCity(start,end).get(0);
        int endInt = searchCity(start,end).get(1);

        boolean startBool;
        List<Train> resultTrains = new ArrayList<>();
        for (Train count : allTrains) {
            startBool = false;
            for (int i = 0; i < count.getStops().size(); i++) {
                if (count.getStops().get(i).getCity() == startInt) {
                    startBool = true;
                }
                if (count.getStops().get(i).getCity() == endInt && startBool) {
                    resultTrains.add(count);
                }
            }
        }
        return resultTrains;
    }

    abstract List<Train> getAllTrains();

    abstract List<City> getAllCity();
}
