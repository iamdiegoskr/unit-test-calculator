package co.com.sofka.app.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1 + 1 = 2")
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
    @DisplayName("Testing subtraction: 10 - 5 = 5")
    public void subtraction() {

        Long number1 = 10L;
        Long number2 = 5L;
        Long expectedValue = 5L;

        Long result = basicCalculator.subtraction(number1, number2);

        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing different subtractions")
    @ParameterizedTest(name = "{0} - {1} = {2}")
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

    @Test
    @DisplayName("Testing multiplication: 5 * 5 = 25")
    public void multiplication() {

        Long number1 = 5L;
        Long number2 = 5L;
        Long expectedValue = 25L;

        Long result = basicCalculator.multiplication(number1, number2);

        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing different multiplications")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "9,   9,  81",
            "10,  10,  100",
            "7,   0,   0",
            "10,  1, 10",
            "3,   -3,  -9",
            "6,  6,  36"
    })
    public void severalMultiplications(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiplication(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing sum: 6 / 2 = 3")
    public void division() {

        Long number1 = 6L;
        Long number2 = 2L;
        Long expectedValue = 3L;

        Long result = basicCalculator.division(number1, number2);

        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing sum: 2 / 0 = Exepcion")
    public void divisionByZero() {

        Long number1 = 2L;
        Long number2 = 0L;

        Assertions.assertThrows(ArithmeticException.class,()->{
            Long result = basicCalculator.division(number1, number2);
        });
    }

    @DisplayName("Testing different divisions")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "10,  5,  2",
            "100,  100,  1",
            "0,   2,   0",
            "200,  10, 20",
            "10,   -2,  -5"
    })
    public void severalDivisions(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.division(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }



}
