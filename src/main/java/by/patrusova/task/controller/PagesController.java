package by.patrusova.task.controller;

import by.patrusova.task.entity.Room;
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

    public PagesController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String backToIndex() {
        return "index";
    }

    @RequestMapping(value = "/roomy/{roomId}", method = RequestMethod.GET)
    public String enterRoom(@PathVariable Integer roomId, Model model) {
        Optional<Room> optional = roomService.findRoomById(roomId);
        if (optional.isPresent()) {
            model.addAttribute("room", optional.get());
            model.addAttribute("lamp", optional.get().getLamp());
            return "roomy";
        } else {
            return "index";
        }
    }

}
