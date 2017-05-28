package service;

import models.City;
import models.Train;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractTrainService implements TrainService {
    @Override
    public List<Integer> searchCity(String start, String end){
        List<City> allCity = getAllCity();
        List<Integer> startEnd = new ArrayList<>();
        startEnd.add(null);
        startEnd.add(null);
        for (City count : allCity) {
            if (start.equalsIgnoreCase(count.getCityName())) {
                startEnd.set(0,count.getId());
            }
            if (end.equalsIgnoreCase(count.getCityName())) {
                startEnd.set(1,count.getId());
            }
        }
        return startEnd;
    }
    @Override
    public List<Train> search(String start, String end, LocalDate date) {

        List<Train> allTrains = getAllTrains();

        Integer startInt = searchCity(start,end).get(0);
        Integer endInt = searchCity(start,end).get(1);

        boolean startBool,dateBool;

        String needDate = (date.toString());
        List<Train> resultTrains = new ArrayList<>();
        for (Train count : allTrains) {
            startBool =dateBool = false;
            for (int i = 0; i < count.getStops().size(); i++) {
                if (count.getStops().get(i).getCity() == startInt) {
                    startBool = true;
                    String getDate = (count.getStops().get(i).getDate().toString());
                    getDate = getDate.substring(0,10);
                    if(getDate.equalsIgnoreCase(needDate)){
                        dateBool = true;
                    }
                }
                if (count.getStops().get(i).getCity() == endInt && startBool &&dateBool) {
                    resultTrains.add(count);
                }
            }
        }
        return resultTrains;
    }

    abstract List<Train> getAllTrains();

    abstract List<City> getAllCity();
}
