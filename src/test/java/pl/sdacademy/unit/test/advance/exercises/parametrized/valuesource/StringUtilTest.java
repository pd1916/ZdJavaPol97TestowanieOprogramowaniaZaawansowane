package pl.sdacademy.unit.test.advance.exercises.parametrized.valuesource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilTest {
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "  "})
    void shouldReturnTrueIfStringIsBlank(String input) {
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertTrue(result);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " a", "a ", " a "})
    void shouldReturnFalseIfStringIsNotEmpty(String input) {
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertFalse(result);
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnTrueIfStringIsNull() {
        //when
        boolean result = StringUtil.isBlank(null);
        //then
        assertTrue(result);
        assertThat(result).isTrue();
    }
}