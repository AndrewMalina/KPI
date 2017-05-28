package service;

import models.Train;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TrainService {
    List<Integer> searchCity(String start, String end);
    List<Train> search(String start,String end,LocalDate date);
}
