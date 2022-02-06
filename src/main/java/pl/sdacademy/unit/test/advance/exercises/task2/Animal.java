package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.Objects;

public class Animal {
    private Long id;
    private String name;
    private String type;

    public Animal(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) && Objects.equals(name, animal.name) && Objects.equals(type, animal.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}
