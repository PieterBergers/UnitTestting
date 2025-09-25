package week2;

import java.util.HashSet;
import java.util.Set;

public class ArrayOfInts {

    int sumOfUniqueValidNumbers(int[] numbers) {
        if (numbers == null)
            throw new IllegalArgumentException("Argument cannot be null.");

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int number : numbers) {
            if (number < 0)
                throw new IllegalArgumentException("Argument cannot contain negative number.");

            if (number <= 1000)
                uniqueNumbers.add(number);
        }

        return uniqueNumbers.stream().mapToInt(Integer::intValue).sum();
    }
}
