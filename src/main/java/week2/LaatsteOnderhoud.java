package week2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LaatsteOnderhoud {

    public Map<String, LocalDate> licensePlateToMap(String[] licensePlates) {
        Map<String, LocalDate> result = new HashMap<>();
        Map<String, LocalDate> recentPlates = new HashMap<>();
        LocalDate currentDay = LocalDate.now();

        if (licensePlates == null) throw new IllegalArgumentException("Argument cannot be null.");

        for (String line : licensePlates) {

            String[] parts = line.split(",");
            String nummerplaat = parts[0];
            LocalDate datum = LocalDate.parse(parts[1]);

            if (datum.isAfter(currentDay.minusYears(1))) recentPlates.put(nummerplaat, datum);

            else if ((!result.containsKey(nummerplaat) || datum.isAfter(result.get(nummerplaat)))
                    && !recentPlates.containsKey(nummerplaat))
                result.put(nummerplaat, datum);
        }

        return result;
    }
}
