package week2_OPL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOfIntsTest {
    private final ArrayOfInts arrayOfInts = new ArrayOfInts();

    @Test
    public void testSumOfUniqueAndValidInts_arrayIsEmpty_ReturnsZero() {
        assertEquals(0, arrayOfInts.sumOfUniqueAndValidInts(null));
        assertEquals(0, arrayOfInts.sumOfUniqueAndValidInts(new int[]{}));
    }

    @Test
    public void testSumOfUniqueAndValidInts_arrayHasUniqueValidNumbersOnly_ReturnsSum() {
        assertEquals(1004, arrayOfInts.sumOfUniqueAndValidInts(new int[]{0, 2, 3, 999}));
        assertEquals(0, arrayOfInts.sumOfUniqueAndValidInts(new int[]{0}));
        assertEquals(999, arrayOfInts.sumOfUniqueAndValidInts(new int[]{999}));
    }

    @Test
    public void testSumOfUniqueAndValidInts_arrayHasNegativeNumber_ThrowsException() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> arrayOfInts.sumOfUniqueAndValidInts(new int[]{1, 2, -1, 5}));

        assertEquals("The array contains negative numbers.", e.getMessage());
    }

    @Test
    public void testSumOfUniqueAndValidInts_arrayHasDuplicateNumber_IgnoresDuplicates() {
        assertEquals(15, arrayOfInts.sumOfUniqueAndValidInts(new int[]{1, 2, 2, 3, 3, 4, 5, 1}));
    }

    @Test
    void findCommonElements_firstArrayIsEmpty_throwsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> arrayOfInts.findCommonElements(null, new int[]{}));
        assertEquals("Arguments cannot be null.", exception.getMessage());
    }

    @Test
    void findCommonElements_secondArrayIsEmpty_throwsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> arrayOfInts.findCommonElements(new int[]{}, null));
        assertEquals("Arguments cannot be null.", exception.getMessage());
    }

    @Test
    void findCommonElements_bothArraysAreEmpty_throwsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> arrayOfInts.findCommonElements(null, null));
        assertEquals("Arguments cannot be null.", exception.getMessage());
    }

    @Test
    void findCommonElements_EmptyArray_returnsEmptyArray() {
        assertArrayEquals(new int[]{}, arrayOfInts.findCommonElements(new int[]{}, new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{}, arrayOfInts.findCommonElements(new int[]{1, 4, 6}, new int[]{}));
        assertArrayEquals(new int[]{}, arrayOfInts.findCommonElements(new int[]{}, new int[]{}));
    }

    @Test
    void findCommonElements_hasNoCommonElements_returnsEmptyArray() {
        assertArrayEquals(new int[]{}, arrayOfInts.findCommonElements(new int[]{1, 2, 3, 4}, new int[]{-1, -2, -3, -4}));
    }

    @Test
    void findCommonElements_hasCommonElements_returnsCommonElements() {
        assertArrayEquals(new int[]{1, 4}, arrayOfInts.findCommonElements(new int[]{1, 2, 3, 4}, new int[]{1, -2, -3, 4, 5}));
    }

    @Test
    void findUniqueElements_nullArray_throwsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> arrayOfInts.findUniqueElements(null, null));
        assertEquals("Arguments cannot be null.", exception.getMessage());
    }

    @Test
    void findUniqueElements_emptyArray_returnsEmptyArray() {
        assertArrayEquals(new int[]{}, arrayOfInts.findUniqueElements(new int[]{}, new int[]{}));
    }

    @Test
    void findUniqueElements_hasNoUniqueValues_returnsEmptyArray() {
        assertArrayEquals(new int[]{}, arrayOfInts.findUniqueElements(new int[]{1, 3, 5, 7, 9, -5, -1, 0}, new int[]{1, 3, 5, 7, 9, -5, -1, 0}));
    }

    @Test
    void findUniqueElements_hasUniqueValues_returnsUniqueElements() {
        assertArrayEquals(new int[]{1, 2, 4}, arrayOfInts.findUniqueElements(new int[]{1, 3, 5, 7, 9, -5, -1, 0}, new int[]{3, 5, 7, 9, -5, -1, 0, 2, 4}));
    }

    @Test
    void findUniqueElements_hasDuplicates_returnsUniqueElements() {
        assertArrayEquals(new int[]{1, 2, -4}, arrayOfInts.findUniqueElements(new int[]{1, 3, 5, 7, -4, 9, 1, -5, -1, 0}, new int[]{3, 5, 7, 9, -5, -1, 0, 2}));
    }

    @Test
    void findDuplicateValues_nullArray_throwsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> arrayOfInts.findDuplicateValues(null));
        assertEquals("Argument cannot be null.", exception.getMessage());
    }

    @Test
    void findDuplicateValues_emptyArray_returnsEmptyArray() {
        assertArrayEquals(new int[]{}, arrayOfInts.findDuplicateValues(new int[0]));
    }

    @Test
    void findDuplicateValues_noDuplicates_returnsEmptyArray() {
        assertArrayEquals(new int[]{}, arrayOfInts.findDuplicateValues(new int[]{1, 3, 5, 7, 9, -5, -1, 0}));
    }

    @Test
    void findDuplicateValues_hasDuplicates_returnsArrayWithDuplicates() {
        assertArrayEquals(new int[]{5, 3}, arrayOfInts.findDuplicateValues(new int[]{1, 3, 5, 7, 9, 5, -1, 0, 3}));
    }

    @Test
    public void groupByNumberOfDigits_arrayIsEmpty_returnsEmptyArray() {
        assertArrayEquals(new int[][]{}, arrayOfInts.groupByNumberOfDigits(null));
        assertArrayEquals(new int[][]{}, arrayOfInts.groupByNumberOfDigits(new int[]{}));
    }

    @Test
    public void groupByNumberOfDigits_numbersAreInOrder_returnsGroupedArray() {
        assertArrayEquals(
                new int[][]{{5, 9}, {10, 67, 99}, {1234, 8998}},
                arrayOfInts.groupByNumberOfDigits(new int[]{5, 9, 10, 67, 99, 1234, 8998}));
    }

    @Test
    public void groupByNumberOfDigits_numbersAreNotInOrder_returnsGroupedAndSortedArray() {
        assertArrayEquals(
                new int[][]{{5, 9}, {10, 67, 99}, {1234, 8998}},
                arrayOfInts.groupByNumberOfDigits(new int[]{9, 8998, 67, 1234, 99, 10, 5}));
    }
}
