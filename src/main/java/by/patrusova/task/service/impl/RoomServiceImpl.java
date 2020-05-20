package by.patrusova.task.service.impl;

import by.patrusova.task.entity.Lamp;
import by.patrusova.task.entity.Room;
import by.patrusova.task.exception.ValidationException;
import by.patrusova.task.repository.RoomsRepository;
import by.patrusova.task.service.RoomService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static java.util.Objects.isNull;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomsRepository roomsRepository;

    public RoomServiceImpl(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    private void validateRoom(Room room) throws ValidationException {
        if (isNull(room)) {
            throw new ValidationException("Room does not exist.");
        }
        if (isNull(room.getCountry()) || room.getCountry().isEmpty()) {
            throw new ValidationException("Room has got no address.");
        }
        if (isNull(room.getName()) || room.getName().isEmpty()) {
            throw new ValidationException("Room is nameless.");
        }
    }

    @Override
    public Room saveRoom(Room room) throws ValidationException {
        validateRoom(room);
        Room room1 = findByName(room.getName());
        if (room1 != null) {
            return room1;
        }
        Lamp lamp = new Lamp("off");
        lamp.setRoom(room);
        room.setLamp(lamp);
        return roomsRepository.save(room);
    }
    @Override
    public void deleteRoom(Integer roomId) {
        roomsRepository.deleteById(roomId);
    }
    @Override
    public List<Room> findByCountry(String country) {
        return new ArrayList<>(roomsRepository.findByCountry(country));
    }
    @Override
    public Room findByName(String name) {
        return roomsRepository.findByName(name);
    }
    @Override
    public List<Room> findAll() {
        return new ArrayList<>(roomsRepository.findAll());
    }
    @Override
    public Optional<Room> findRoomById(Integer id) {
        return roomsRepository.findById(id);
    }
}