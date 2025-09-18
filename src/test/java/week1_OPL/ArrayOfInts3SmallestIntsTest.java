package week1_OPL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOfInts3SmallestIntsTest {

    @Test
    void sumOf3SmallestInts() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();

        int sumOf3SmallestInts = arrayOfInts.sumOf3SmallestInts(new int[]{1, 2, 3, 4, 5});

        assertEquals(6, sumOf3SmallestInts);
    }

    @Test
    void sumOf3SmallestInts_nullParameter_returns0() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();

        int sumOf3SmallestInts = arrayOfInts.sumOf3SmallestInts(null);

        assertEquals(0, sumOf3SmallestInts);
    }

    @Test
    void sumOf3SmallestInts_emptyArray_returns0() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();

        int sumOf3SmallestInts = arrayOfInts.sumOf3SmallestInts(new int[]{});

        assertEquals(0, sumOf3SmallestInts);
    }

    @Test
    void sumOf3SmallestInts_lessThanX_returnsSum() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();

        int sumOf3SmallestInts = arrayOfInts.sumOf3SmallestInts(new int[]{5, 8});

        assertEquals(13, sumOf3SmallestInts);
    }

}