package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101",
            "7,    3,  10"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing subtraction: 10-5=5")
    public void subtraction() {
        // Arrange
        Long number1 = 10L;
        Long number2 = 5L;
        Long expectedValue = 5L;

        // Act
        Long result = basicCalculator.subtraction(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing different subtractions")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "4,   2,   2",
            "100, 99,   1",
            "20,  40, -20",
            "30,  15, 15",
            "77,   7,  70",
            "-5,  -5,  0"
    })
    public void severalSubtractions(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.subtraction(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

}
