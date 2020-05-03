package by.patrusova.task.service;

import by.patrusova.task.entity.Room;
import by.patrusova.task.exception.ValidationException;
import java.util.List;
import java.util.Optional;

public interface RoomService {

    Room saveRoom(Room room) throws ValidationException;
    void deleteRoom(Integer roomId);
    List<Room> findByCountry(String country);
    Room findByName(String name);
    Optional<Room> findRoomById(Integer roomId);
    List<Room> findAll();
}