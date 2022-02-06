package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.List;

public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getById(Long id) {
        return animalRepository.findById(id).orElseThrow();
    }

    public List<Animal> getByType(String type) {
        return animalRepository.findByType(type);
    }

    public Animal add(String name, String type) {
        return animalRepository.add(new Animal(name, type));
    }
}
