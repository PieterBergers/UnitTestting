package week2_OPL;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMaintenance {
    public Map<String, LocalDate> listCarsNeedingMaintenance(List<String> carHistory) {
        if (carHistory == null) throw new IllegalArgumentException("carHistory cannot be null");

        Map<String, LocalDate> carHistoryMap = new HashMap<>();

        for (String history : carHistory) {
            String[] parts = history.split(",");
            String licensePlate = parts[0];
            LocalDate maintenanceDate = LocalDate.parse(parts[1]);

            if (carHistoryMap.containsKey(licensePlate)) {
                if (maintenanceDate.isAfter(carHistoryMap.get(licensePlate))) {
                    carHistoryMap.put(licensePlate, maintenanceDate);
                }
            } else {
                carHistoryMap.put(licensePlate, maintenanceDate);
            }
        }

        return carHistoryMap.entrySet().stream()
                .filter(entry -> entry.getValue().isBefore(LocalDate.now().minusYears(1)))
                .collect(
                        HashMap::new,
                        (target, entry) -> target.put(entry.getKey(), entry.getValue()),
                        HashMap::putAll);
    }
}
