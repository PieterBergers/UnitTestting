package week2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayOfIntsTest {
    ArrayOfInts arrayOfInts = new ArrayOfInts ();

    @Test
    void sumOfUNiqueValidNumbers_emptyArray_returns0() {
        assertEquals(0, arrayOfInts.sumOfUniqueValidNumbers(new int[]{}));
    }

    @Test
    void sumOfUniqueValidNumbers_nullArray_ThrowsException() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> arrayOfInts.sumOfUniqueValidNumbers(null));

        //check dat de gegooide exception de juiste exception is
        assertEquals("Argument cannot be null.", exception.getMessage());
    }

    @Test
    void sumOfUniqueValidNumbers_ArrayWithNegative_ThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> arrayOfInts.sumOfUniqueValidNumbers(new int[]{8, 10, -1, 5}));

    }

    @Test
    void sumOfUniqueValidNumbers_validArray_returnsSum() {
        assertEquals(15,
                arrayOfInts.sumOfUniqueValidNumbers(new int[]{1,2,3,4,5}));
    }

    @Test
    void sumOfUniqueValidNumbers_numberAbove1000_IgnoresNumber() {
        assertEquals(1005,
                arrayOfInts.sumOfUniqueValidNumbers(new int[]{5, 0, 1000, 1001}));
    }
    @Test
    void sumOfUniqueValidNumbers_validArrayWithDuplicates_IgnoresDuplicates() {
        assertEquals(6,
                arrayOfInts.sumOfUniqueValidNumbers(new int[]{5, 1, 5}));
    }
}
