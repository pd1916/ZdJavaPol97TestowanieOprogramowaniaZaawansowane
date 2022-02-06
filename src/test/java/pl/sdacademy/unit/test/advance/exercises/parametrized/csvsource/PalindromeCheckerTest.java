package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeCheckerTest {
    @ParameterizedTest
    @CsvSource({
            "kajak, true",
            "java, false",
            "kobyła ma mały bok, true",
            "sedes, true",
            "' kajak', true"
    })
    void shouldVerifyIfWordIsPalindromeCsvSource(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv")
    void shouldReturnIfWordIsPalindromeCsvFileSource(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result);
        assertThat(result).isEqualTo(expectedResult);
    }
}