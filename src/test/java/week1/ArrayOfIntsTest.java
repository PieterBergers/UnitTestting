package week1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ArrayOfIntsTest {
    @Test
    void sumOfInts_InputHasNoValue_returnsZero() {
      ArrayOfInts a = new ArrayOfInts();
      assertEquals(0, a.sumOfInts(null));
    }

    @Test
    void sumOfInts_InputHasEmptyValue_returnsZero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.sumOfInts(new int[] {}));
    }

    @Test
    void sumOfInts_InputHasValue_returns8() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(8, a.sumOfInts(new int[] {4, -6, 10}));
    }

    @Test
    void sumOf3SmallestInts_InputHasNoValue_returnsZero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.sumOf3SmallestInts(null));
    }

    @Test
    void sumOf3SmallestInts_InputHasEmptyValue_returnsZero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.sumOf3SmallestInts(new int[] {}));
    }

    @Test
    void sumOf3SmallestInts_InputHasValue_returnsMinus5() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(-5, a.sumOf3SmallestInts(new int[] {3, 5, -2, -6, 7}));
    }

    @Test
    void sumOfEven_InputHasNoValue_returnsZero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.sumOfEven(null));
    }

    @Test
    void sumOfEven_InputHasEmptyValue_returnsZero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.sumOfEven(new int[] {}));
    }

    @Test
    void sumOfEven_InputHasValue_returnsMinus4() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(-4, a.sumOfEven(new int[] {3, 5, -2, -6, 7, 4}));
    }

    @Test
    void sumOfXLargest_InputHasEmptyValue_returnsZero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.sumOfXLargest(null, 0));
    }

    @Test
    void sumOfXLargest_InputHasNegativeXValue_returnsZero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.sumOfXLargest(new int[] {1, 2, 3, 4}, -1));
    }

    @Test
    void sumOfXLargest_InputHasValue_returns9() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(9, a.sumOfXLargest(new int[] {4, 1, 3, 2}, 3));
    }

    @Test
    void sumOfXLargest_InputIsZero_returnsZero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.sumOfXLargest(new int[] {}, 2));
    }

    @Test
    void sumOfXLargest_InputIsNull_returnsZero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.sumOfXLargest(null, 0));
    }

    @Test
    void sumOfXLargest_InputHasBiggerX_returns10() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(10, a.sumOfXLargest(new int[] {1, 2, 3, 4}, 5));
    }

    @Test
    void countMostPopularNumber_InputIsnull_returnszero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.countMostPopularNumber(null));
    }

    @Test
    void countMostPopularNumber_InputIsEmpty_returnszero() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(0, a.countMostPopularNumber(new int[] {}));
    }

    @Test
    void countMostPopularNumber_InputHasValue_returns1() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(1, a.countMostPopularNumber(new int[] {1, 4, 2}));
    }

    @Test
    void countMostPopularNumber_InputHasMultipleAndNegativeFavorite_returns2() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(2, a.countMostPopularNumber(new int[] {2, -2, 3, 2, -2, 4, 5}));
    }

    @Test
    void countMostPopularNumber_InputHasUniqueBigFavorite_returns4() {
        ArrayOfInts a = new ArrayOfInts();
        assertEquals(4, a.countMostPopularNumber(new int[]{4, 2, 5, 5, 4, 4, 5, 4, 3, 3}));
    }
}