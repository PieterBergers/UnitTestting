package week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByNumberOfDigits {

    int[] arrayToSortedArray(int[] numbers) {
        if (numbers == null)
            throw new IllegalArgumentException("Argument cannot be null.");

        Map<Integer, List<Integer>> groupedNumbers = new HashMap<>();

        for (int number : numbers) {
            int lengte = Integer.toString(number).length();
            if (!groupedNumbers.containsKey(lengte)) groupedNumbers.put(lengte, new ArrayList<>());
            groupedNumbers.get(lengte).add(number);
        }

        return groupedNumbers.values().stream().flatMap(List::stream).mapToInt(Integer::intValue).sorted().toArray();
    }
}
