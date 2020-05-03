package by.patrusova.task.controller;

import by.patrusova.task.entity.Room;
import by.patrusova.task.exception.ValidationException;
import by.patrusova.task.service.RoomService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomsController {

    private final static Logger LOGGER = LogManager.getLogger();
    private final RoomService roomService;
//    @Value("${errorMessage}")
//    private String errorMessage;

    public RoomsController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/save")
    public Room saveRoom(@RequestBody Room room) throws ValidationException {
        LOGGER.log(Level.INFO, "Attempt to add room: " + room);
//        String name = room.getName();
//        if (name == null || name.equals("") || name.length() > 45) {
//            request.getSession().setAttribute("errorMessage", errorMessage);
//        }
        return roomService.saveRoom(room);
    }

    @GetMapping("/findAll")
    public List<Room> findAllRooms() {
        LOGGER.log(Level.INFO, "Finding all rooms...");
        return roomService.findAll();
    }

    @GetMapping("/findByCountry")
    public List<Room> findByCountry(@RequestParam String country) {
        LOGGER.log(Level.INFO, "Finding room by country: " + country);
        return roomService.findByCountry(country);
    }

    @GetMapping("/findByName")
    public Room findByName(@RequestParam String name) {
        LOGGER.log(Level.INFO, "Finding room by name: " + name);
        return roomService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Attempt to delete room, id: " + id);
        roomService.deleteRoom(id);
        return ResponseEntity.ok().build();
    }
}