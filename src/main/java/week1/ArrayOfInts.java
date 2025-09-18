package week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayOfInts {
    public int sumOfInts(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;
        int sum = 0;
        for (int i : arrayOfInts)
            sum += i;
        return sum;
    }

    public int sumOf3SmallestInts(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;
        int[] copy = Arrays.copyOf(arrayOfInts, arrayOfInts.length);
        Arrays.sort(copy);
        return sumOfInts(Arrays.copyOf(copy, 3));
    }

    public int sumOfEven(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;
        int[] even = new int[arrayOfInts.length];
        int evenLength = 0;
        for (int i : arrayOfInts)
            if (i % 2 == 0) even[evenLength++] = i;
        return sumOfInts(even);
    }

    public int sumOfXLargest(int[] arrayOfInts, int x) {
        if (arrayOfInts == null) return 0;
        if (x < 0) return 0;
        if (x > arrayOfInts.length) x = arrayOfInts.length;
        int[] copy = Arrays.copyOf(arrayOfInts, arrayOfInts.length);
        Arrays.sort(copy);
        return sumOfInts(Arrays.copyOfRange(copy, arrayOfInts.length-x, arrayOfInts.length));
    }

    public int countMostPopularNumber(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;

        Map<Integer, Integer> m = new HashMap<>();
        int maxCount = 0;

        for (int i : arrayOfInts) {
            int count = m.getOrDefault(i, 0) + 1;
            m.put(i, count);
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }
}
