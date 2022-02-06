package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Optional<Animal> findById(Long id);

    List<Animal> findByType(String type);

    Animal add(Animal animal);
}
