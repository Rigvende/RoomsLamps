package by.patrusova.task.controller;

import by.patrusova.task.entity.Lamp;
import by.patrusova.task.entity.Room;
import by.patrusova.task.service.LampService;
import by.patrusova.task.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Optional;

@Controller
public class PagesController {

    private final RoomService roomService;
    private final LampService lampService;

    public PagesController(RoomService roomService, LampService lampService) {
        this.roomService = roomService;
        this.lampService = lampService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String backToIndex() {
        return "index";
    }

    @RequestMapping(value = "/roomy/{roomId}", method = RequestMethod.GET)
    public String enterRoom(@PathVariable Integer roomId, Model model) {
        Optional<Room> optional = roomService.findRoomById(roomId);
        if(optional.isPresent()) {
            model.addAttribute("room", optional.get());
            Optional<Lamp> optional2 = lampService.findLampById(optional.get().getLamp().getId());
            optional2.ifPresent(lamp -> model.addAttribute("lamp", lamp));
            return "roomy";
        }
        else {
            return "index";
        }
    }
}
