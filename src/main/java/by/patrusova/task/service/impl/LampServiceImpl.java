package by.patrusova.task.service.impl;

import by.patrusova.task.entity.Lamp;
import by.patrusova.task.exception.ValidationException;
import by.patrusova.task.repository.LampsRepository;
import by.patrusova.task.service.LampService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static java.util.Objects.isNull;

@Service
public class LampServiceImpl implements LampService {

    private final LampsRepository lampsRepository;

    public LampServiceImpl(LampsRepository lampsRepository) {
        this.lampsRepository = lampsRepository;
    }

    private void validateLamp(Lamp lamp) throws ValidationException {
        if (isNull(lamp)) {
            throw new ValidationException("Lamp does not exist.");
        }
        if (isNull(lamp.getLampCondition()) || lamp.getLampCondition().isEmpty()) {
            throw new ValidationException("Lamp is broken.");
        }
    }

    @Override
    public Lamp saveLamp(Lamp lamp) throws ValidationException {
        validateLamp(lamp);
        Optional<Lamp> optional = lampsRepository.findById(lamp.getId());
        return optional.orElseGet(() -> lampsRepository.save(lamp));
    }
    @Override
    public Lamp updateLamp(Lamp lamp) {
        Optional<Lamp> optional = lampsRepository.findById(lamp.getId());
        if (optional.isPresent()) {
            Lamp foundLamp = optional.get();
            foundLamp.setLampCondition(lamp.getLampCondition());
            return lampsRepository.saveAndFlush(foundLamp);
        }
        return null;
    }
    @Override
    public void deleteLamp(Integer lampId) {
        lampsRepository.deleteById(lampId);
    }
    @Override
    public Lamp findByLampCondition(String lampCondition) {
        return lampsRepository.findByLampCondition(lampCondition);
    }
    @Override
    public List<Lamp> findAll() {
        return new ArrayList<>(lampsRepository.findAll());
    }

    @Override
    public Optional<Lamp> findLampById(Integer id) {
        return lampsRepository.findById(id);
    }
}