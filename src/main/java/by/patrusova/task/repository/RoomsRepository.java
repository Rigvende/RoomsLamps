package by.patrusova.task.repository;

import by.patrusova.task.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomsRepository extends JpaRepository<Room, Integer> {

    List<Room> findByCountry(String country);
    Room findByName(String name);
}