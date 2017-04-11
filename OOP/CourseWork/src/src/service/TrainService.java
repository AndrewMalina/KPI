package service;

import models.Train;

import java.util.Date;
import java.util.List;

public interface TrainService {
    List<Train> search(int start, int end, Date date);
}
