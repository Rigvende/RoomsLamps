package by.patrusova.task.repository;

import by.patrusova.task.entity.Lamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LampsRepository extends JpaRepository<Lamp, Integer> {

        Lamp findByLampCondition(String lampCondition);
}