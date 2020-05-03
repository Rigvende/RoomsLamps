package by.patrusova.task.controller;

import by.patrusova.task.entity.Lamp;
import by.patrusova.task.entity.Room;
import by.patrusova.task.exception.ValidationException;
import by.patrusova.task.service.LampService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/lamp")
public class LampsController {

    private final LampService lampService;
    private final static Logger LOGGER = LogManager.getLogger();

    public LampsController(LampService lampService) {
        this.lampService = lampService;
    }

    @PostMapping("/save")
    public Lamp saveLamp(@RequestBody Lamp lamp) throws ValidationException {
        LOGGER.log(Level.INFO, "Attempt to add lamp: " + lamp);
        return lampService.saveLamp(lamp);
    }

    @GetMapping("/findAll")
    public List<Lamp> findAllLamps() {
        LOGGER.log(Level.INFO,"Finding all lamps...");
        return lampService.findAll();
    }

    @GetMapping("/findByLampCondition")
    public Lamp findByLampCondition(@RequestParam String lampCondition) {
        LOGGER.log(Level.INFO,"Finding lamp by condition: " + lampCondition);
        return lampService.findByLampCondition(lampCondition);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLamp(@PathVariable Integer id) {
        LOGGER.log(Level.INFO,"Attempt to delete lamp, id: " + id);
        lampService.deleteLamp(id);
        return ResponseEntity.ok().build();
    }
}