package week2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GroupByNumberOfDigitsTest {
    GroupByNumberOfDigits groupByNumberOfDigits = new GroupByNumberOfDigits();

    @Test
    void arrayToSortedArray_nullArray_ThrowsException() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> groupByNumberOfDigits.arrayToSortedArray(null));
        assertEquals("Argument cannot be null.", exception.getMessage());
    }

    @Test
    void arrayToSortedArray_emptyArray_returnsEmptyArray() {
        assertArrayEquals(new int[][] {}, groupByNumberOfDigits.arrayToSortedArray(new int[] {}));
    }

    @Test
    void arrayToSortedArray_singleNumberInputWithNegative_returnsSortedNumbers() {
        assertArrayEquals(new int[][] {{-4, 1, 2, 9}}, groupByNumberOfDigits.arrayToSortedArray(new int[] {1, 9, -4, 2}));
    }

    @Test
    void arrayToSortedArray_mixedInput_returnsSortedAndGroupedNumbers() {
        assertArrayEquals(new int[][] { {4, 5, 6}, {22, 22, 63, 64}, {342} }, groupByNumberOfDigits.arrayToSortedArray(new int[] {5, 22, 4, 342, 64, 6, 63, 22}));
    }
}