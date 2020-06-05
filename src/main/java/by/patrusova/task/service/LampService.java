package by.patrusova.task.service;

import by.patrusova.task.entity.Lamp;
import by.patrusova.task.exception.ValidationException;
import java.util.List;
import java.util.Optional;

public interface LampService {

    Lamp saveLamp(Lamp lamp) throws ValidationException;
    Lamp updateLamp(Lamp lamp);
    void deleteLamp(Integer lampId);
    Lamp findByLampCondition(String condition);
    List<Lamp> findAll();
    Optional<Lamp> findLampById(Integer id);
}