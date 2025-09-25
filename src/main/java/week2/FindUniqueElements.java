package week2;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueElements {

    int[] combinationOfUniqueElementsInArray(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) throw new IllegalArgumentException("Argument cannot be null.");

        Set<Integer> uniqueElements = new HashSet<>();

        for (int i = 0; i < array1.length; i++) {
            uniqueElements.add(array1[i]);
        }
        Set<Integer> uniqueElememtsSet1 = new HashSet<>(uniqueElements);
        for (int j = 0; j < array2.length; j++) {
            if (uniqueElememtsSet1.contains(array2[j])) uniqueElements.remove(array2[j]);
            else uniqueElements.add(array2[j]);
        }

        return uniqueElements.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
