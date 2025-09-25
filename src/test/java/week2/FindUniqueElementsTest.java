package week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindUniqueElementsTest {
    FindUniqueElements findUniqueElements = new FindUniqueElements();

    @Test
    void findUniqueElements_nullArrays_ThrowsException() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> findUniqueElements.combinationOfUniqueElementsInArray(null, null));
        assertEquals("Argument cannot be null.", exception.getMessage());
    }

    @Test
    void findUniqueElements_1Array_ThrowsException() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> findUniqueElements.combinationOfUniqueElementsInArray(new int[]{1, 6, 2}, null));
        assertEquals("Argument cannot be null.", exception.getMessage());
    }

    @Test
    void findUniqueElements_emptyArrays_emptyArray() {
        assertArrayEquals(new int[] {},
            findUniqueElements.combinationOfUniqueElementsInArray(new int[]{}, new int[]{}));
    }

    @Test
    void findUniqueElements_1emptyArray_emptyArray() {
        assertArrayEquals(new int[] {2, 5, 9},
                findUniqueElements.combinationOfUniqueElementsInArray(new int[]{}, new int[]{5, 2, 9}));
    }

    @Test
    void findUniqueElements_2UniqueArrays_1CombinedArray() {
        assertArrayEquals(new int[] {1, 2, 4, 5, 7, 8},
                findUniqueElements.combinationOfUniqueElementsInArray(new int[]{1, 2, 5}, new int[]{4, 8, 7}));
    }

    @Test
    void findUniqueElements_2identiqueArrays_1emptyArray() {
        assertArrayEquals(new int[] {},
                findUniqueElements.combinationOfUniqueElementsInArray(new int[]{1, 3, 7}, new int[]{1, 3, 7}));
    }

    @Test
    void findUniqueElements_duplicatesInArray_removedDuplicates() {
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6},
                findUniqueElements.combinationOfUniqueElementsInArray(new int[]{1, 2, 3, 2}, new int[]{4, 5, 6}));
    }

    @Test
    void findUniqueElements_duplicatesAndUnique_combinedArray() {
        assertArrayEquals(new int[] {3, 5, 7},
                findUniqueElements.combinationOfUniqueElementsInArray(new int[]{1, 5}, new int[]{3, 1, 3, 7}));
    }
}
