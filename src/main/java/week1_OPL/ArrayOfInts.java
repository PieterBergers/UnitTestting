package week1_OPL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;

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
        if (arrayOfInts == null || arrayOfInts.length == 0) return 0;
        if (x <= 0) return 0;

        int[] copy = Arrays.copyOf(arrayOfInts, arrayOfInts.length);
        Arrays.sort(copy);

        if (arrayOfInts.length < x)
            return sumOfInts(copy);
        else
            return sumOfInts(Arrays.copyOfRange(copy, copy.length - x, copy.length));
    }

    public int countMostPopularNumber(int[] arrayOfInts) {
        if (arrayOfInts == null || arrayOfInts.length == 0) return 0;

        int[] copy = Arrays.copyOf(arrayOfInts, arrayOfInts.length);
        Arrays.sort(copy);

        int count = 1;
        int maxcount = 1;
        int lastValue = copy[0];
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] == lastValue) {
                count++;
            } else {
                if (count > maxcount) maxcount = count;
                count = 1;
                lastValue = copy[i];
            }
        }

        if (count > maxcount) maxcount = count;

        return maxcount;
    }

    public int countMostPopularNumber_map(int[] arrayOfInts) {
        if (arrayOfInts == null || arrayOfInts.length == 0) return 0;
        int[] copy = Arrays.copyOf(arrayOfInts, arrayOfInts.length);
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : copy) {
            countMap.compute(i, (key, value) -> value == null ? 1 : value + 1);
        }

        Integer[] values = countMap.values().toArray(new Integer[0]);
        Arrays.sort(values);

        return values[values.length - 1];
    }

    public int countMostPopularNumber_stream(int[] arrayOfInts) {
        if (isNull(arrayOfInts)) return 0;

        return IntStream.of(arrayOfInts).boxed()
                .collect(Collectors.groupingByConcurrent(nbr -> nbr, Collectors.counting()))
                .values().stream().mapToInt(Long::intValue).max().orElse(0);

    }
}
