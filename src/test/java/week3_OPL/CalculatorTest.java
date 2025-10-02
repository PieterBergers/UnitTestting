package week3_OPL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void calculate_inputIsNull_ThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(null);
        });
        assertEquals("Input cannot be null", exception.getMessage());
    }

    @Test
    void calculate_inputIsEmpty_ThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("");
        });
        assertEquals("Input cannot be empty", exception.getMessage());
    }

    @Test
    void calculate_inputIsSingleNumber_ReturnsThatNumber() {
        assertEquals(5, calculator.calculate("5"));
        assertEquals(0, calculator.calculate("0"));
        assertEquals(123, calculator.calculate("123"));
    }

    @Test
    void calculate_inputIsAddition_ReturnsSum() {
        assertEquals(8, calculator.calculate("5+3"));
        assertEquals(15, calculator.calculate("0+10+5"));
        assertEquals(100, calculator.calculate("50+50-0"));
    }

    @Test
    void calculate_inputIsSubtraction_ReturnsDifference() {
        assertEquals(2, calculator.calculate("5-3"));
        assertEquals(5, calculator.calculate("10-5"));
        assertEquals(0, calculator.calculate("50-50"));
    }

    @Test
    void calculate_inputIsMixedOperations_ReturnsCorrectResult() {
        assertEquals(4, calculator.calculate("5+3-4"));
        assertEquals(10, calculator.calculate("10-5+5"));
        assertEquals(20, calculator.calculate("50-30+0"));
    }

    @Test
    void calculate_inputContainsWhitespace_ReturnsCorrectResult() {
        assertEquals(4, calculator.calculate(" 5 + 3 - 4"));
        assertEquals(10, calculator.calculate("10 -\n5+5 "));
        assertEquals(20, calculator.calculate("50-30\t+ 0"));
    }

    @Test
    void calculate_inputStartsNegative_ReturnsCorrectResult() {
        assertEquals(246, calculator.calculate("-50+300-4"));
        assertEquals(-5, calculator.calculate("-50+30-5+20"));
    }

    @Test
    void calculate_inputHasIllegalCharacters_ThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("5a+3");
        });
        assertEquals("Invalid character in expression: a", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("5+8!"));
    }

    @Test
    void calculate_inputHasIncorrectOrder_ThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("5++3");
        });
        assertEquals("Invalid format in expression at position 2", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("--5"));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("5-"));
    }
}