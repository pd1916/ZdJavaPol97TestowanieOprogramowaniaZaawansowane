package pl.sdacademy.unit.test.advance.exercises.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {
    private static final Long CAT_ID = 1L;
    private static final String CAT_NAME = "Lew";
    private static final String CAT_TYPE = "Kot";
    private static final Animal ANIMAL = new Animal(CAT_ID, CAT_NAME, CAT_TYPE);

    @Mock
    private AnimalRepository animalRepository;
    @InjectMocks
    private AnimalService animalService;

    @Test
    void shouldReturnAnimalById() {
        //given
        when(animalRepository.findById(CAT_ID)).thenReturn(Optional.of(ANIMAL));
        //when
        Animal actualAnimal = animalService.getById(CAT_ID);
        //then
        assertThat(actualAnimal).isEqualTo(ANIMAL);
    }

    @Test
    void shouldThrowExceptionWhenAnimalNotExistById() {
        //given
        when(animalRepository.findById(CAT_ID)).thenReturn(Optional.empty());
        //when & then
        assertThatThrownBy(() -> animalService.getById(CAT_ID))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void shouldReturnAnimalByType() {
        //given
        when(animalRepository.findByType(CAT_TYPE)).thenReturn(List.of(ANIMAL));
        //when
        List<Animal> actualAnimal = animalService.getByType(CAT_TYPE);
        //then
        assertThat(actualAnimal).hasSize(1);
        assertThat(actualAnimal.get(0)).isEqualTo(ANIMAL);
    }

    @Test
    void shouldCreateAnimal() {
        //given
        Animal inputAnimal = new Animal(CAT_NAME, CAT_TYPE);
        when(animalRepository.add(inputAnimal)).thenReturn(ANIMAL);
        //when
        Animal result = animalService.add(CAT_NAME, CAT_TYPE);
        //then
        assertThat(result.getName()).isEqualTo(inputAnimal.getName());
        assertThat(result.getType()).isEqualTo(inputAnimal.getType());
        assertThat(result.getId()).isPositive();
    }
}