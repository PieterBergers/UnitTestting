package week2_OPL;

import java.util.*;

public class ArrayOfInts {
    public int sumOfUniqueAndValidInts(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;

        return Arrays.stream(numbers)
                .distinct()
                .peek(number -> {
                    if (number < 0) throw new IllegalArgumentException("The array contains negative numbers.");
                })
                .sum();
    }

    public int[] findCommonElements(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) throw new IllegalArgumentException("Arguments cannot be null.");

        List<Integer> commonElements = new ArrayList<>();
        for (int arr1Number : arr1) {
            for (int arr2Number : arr2) {
                if (arr1Number == arr2Number) {
                    commonElements.add(arr1Number);
                }
            }
        }

        return commonElements.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] findUniqueElements(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) throw new IllegalArgumentException("Arguments cannot be null.");

        Set<Integer> uniqueElements = new HashSet<>();
        for (int arr1Number : arr1) {
            if (!contains(arr2, arr1Number))
                uniqueElements.add(arr1Number);
        }
        for (int arr2Number : arr2) {
            if (!contains(arr1, arr2Number))
                uniqueElements.add(arr2Number);
        }
        return uniqueElements.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean contains(int[] arr, int number) {
        for (int arrNumber : arr) {
            if (arrNumber == number) return true;
        }
        return false;
    }

    public int[] findDuplicateValues(int[] numbers) {
        if (numbers == null) throw new IllegalArgumentException("Argument cannot be null.");

        List<Integer> duplicateValues = new ArrayList<>();
        List<Integer> numbersList = new ArrayList<>();

        for (int number : numbers) {
            if (numbersList.contains(number))
                duplicateValues.add(number);
            else
                numbersList.add(number);
        }

        return duplicateValues.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[][] groupByNumberOfDigits(int[] numbers) {
        if (numbers == null || numbers.length == 0) return new int[0][0];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int number : numbers) {
            Integer length = String.valueOf(number).length();
            List<Integer> list = map.getOrDefault(length, new ArrayList<>());
            list.add(number);

            map.put(length, list);
        }
        return map.values()
                .stream()
                .map(nrs -> nrs.stream().mapToInt(Integer::intValue).sorted().toArray())
                .toList()
                .toArray(new int[][]{});
    }
}
