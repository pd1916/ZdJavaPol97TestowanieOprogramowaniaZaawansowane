package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @ParameterizedTest
    @MethodSource("provideData")
    void shouldReturnCorrectValue(int input, int expectedResult) {
        //when
        int result = Fibonacci.getValueFromIndex(input);
        //then
        assertEquals(expectedResult, result);
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(4, 3),
                Arguments.of(8, 21),
                Arguments.of(20, 6765)
        );
    }
}