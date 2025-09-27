package week2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LaatsteOnderhoudTest {
    LaatsteOnderhoud laatsteOnderhoud = new LaatsteOnderhoud();

    @Test
    void licensePlateToMap_nullInput_throwsException() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> laatsteOnderhoud.licensePlateToMap(null));

        assertEquals("Argument cannot be null.", exception.getMessage());
    }

    @Test
    void licensePlateToMap_emptyList_returnsEmptyMap() {
        Map<String, LocalDate> expected = Map.of();

        Map<String, LocalDate> result = laatsteOnderhoud.licensePlateToMap(new String[]{});

        assertEquals(expected, result);
    }

    @Test
    void licensePlateToMap_1string_returnsMapWithInput() {
        Map<String, LocalDate> expected = Map.of("1-ABC-123", LocalDate.of(2021, 2, 3));

        Map<String, LocalDate> result = laatsteOnderhoud.licensePlateToMap(new String[]{"1-ABC-123,2021-02-03"});

        assertEquals(expected, result);
    }

    @Test
    void licensePlateToMap_sameLicensePlateTwice_returnsNewestDate() {
        Map<String, LocalDate> expected = Map.of(
                "1-ABC-123", LocalDate.of(2023, 5, 7),
                "2-DEF-456", LocalDate.of(2019, 5, 12));

            Map<String, LocalDate> result = laatsteOnderhoud.licensePlateToMap(new String[]{
                    "1-ABC-123,2023-05-07","2-DEF-456,2019-05-12","1-ABC-123,2021-02-03"});

        assertEquals(expected, result);
    }

    @Test
    void licensePlateToMap_sameDateTwice_returnsMapWithInput() {
        Map<String, LocalDate> expected = Map.of(
                "1-ABC-123", LocalDate.of(2021, 2, 3),
                "1-GHI-789", LocalDate.of(2023, 5, 7),
                "2-DEF-456", LocalDate.of(2021, 2, 3));

        Map<String, LocalDate> result = laatsteOnderhoud.licensePlateToMap(new String[]{
                "1-ABC-123,2021-02-03", "1-GHI-789,2023-05-07", "2-DEF-456,2021-02-03"});

        assertEquals(expected, result);
    }

    @Test
    void licensePlateToMap_lessThenYearOld_onlyReturnsRecentPlates() {
        Map<String, LocalDate> expected = Map.of("1-GHI-789", LocalDate.of(2024, 9, 20));

        Map<String, LocalDate> result = laatsteOnderhoud.licensePlateToMap(new String[]{
                "1-ABC-123,2025-02-03","1-GHI-789,2024-09-20","2-DEF-456,2024-09-30"});

        assertEquals(expected, result);
    }

    @Test
    void licensePlateToMap_oldAndRecentSamePlate_doesNotReturnThatPlate() {
        Map<String, LocalDate> expected = Map.of("1-GHI-789", LocalDate.of(2024, 9, 20));

        Map<String, LocalDate> result = laatsteOnderhoud.licensePlateToMap(new String[]{
                "1-ABC-123,2025-02-03","1-GHI-789,2024-09-20","1-ABC-123,2022-09-30"});

        assertEquals(expected, result);
    }
}