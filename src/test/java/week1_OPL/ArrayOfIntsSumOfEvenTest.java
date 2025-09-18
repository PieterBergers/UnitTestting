package week1_OPL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOfIntsSumOfEvenTest {

    private final ArrayOfInts arrayOfInts = new ArrayOfInts();

    @Test
    void sumOfEven_onlyEven_returnsSum() {
        int result = arrayOfInts.sumOfEven(new int[]{2, 4});
        assertEquals(6, result);
    }

    @Test
    void sumOfEven_mix_returnsSum() {
        int result = arrayOfInts.sumOfEven(new int[]{1, 2, 7, 6});
        assertEquals(8, result);
    }

    @Test
    void sumOfEven_onlyUneven_returns0() {
        int result = arrayOfInts.sumOfEven(new int[]{7, 1, 3});
        assertEquals(0, result);
    }

    @Test
    void sumOfEven_emptyArray_returns0() {
        int result = arrayOfInts.sumOfEven(new int[]{});
        assertEquals(0, result);
    }

    @Test
    void sumOfEven_nullArray_returns0() {
        int result = arrayOfInts.sumOfEven(null);
        assertEquals(0, result);
    }

}