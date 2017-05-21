package service;

import models.City;
import models.Train;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTrainService implements TrainService {
    @Override
    public List<Train> search(String start, String end) {

        List<Train> allTrains = getAllTrains();
        List<City> allCity = getAllCity();

        int startInt = 0;
        int endInt = 0;

        for (City count : allCity) {
            if (start.equals(count.getId())) {
                startInt = count.getId();
            }
            if (end.equals(count.getId())) {
                endInt = count.getId();
            }
        }
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
        return allTrains;
    }

    abstract List<Train> getAllTrains();

    abstract List<City> getAllCity();
}
