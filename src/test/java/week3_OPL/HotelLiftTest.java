package week3_OPL;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HotelLiftTest {
    @Test
    void badgeIsEmptyString_throwsException(){
        HotelLift hotelLift = new HotelLift();
        assertThrows(IllegalArgumentException.class, () ->
                hotelLift.activeButtons("",7));
    }

    @Test
    void badgeIsInvalid_throwsException(){
        HotelLift hotelLift = new HotelLift();
        assertThrows(IllegalArgumentException.class, () ->
                hotelLift.activeButtons("ABC",0));
    }

    @Test
    void currentLevelOutOfBoundsDown_throwsException(){
        HotelLift hotelLift = new HotelLift();
        assertThrows(IllegalArgumentException.class, () ->
                hotelLift.activeButtons("308",-3));
    }

    @Test
    void currentLevelOutOfBoundsUp_throwsException(){
        HotelLift hotelLift = new HotelLift();
        assertThrows(IllegalArgumentException.class, () ->
                hotelLift.activeButtons("308",11));
    }
    @Test
    void badgeOnInaccessibleLevel_throwsException(){
        HotelLift hotelLift = new HotelLift();
        assertThrows(IllegalArgumentException.class, () ->
                hotelLift.activeButtons("205",-1));
    }

    @Test
    void badgeIsNullOnInaccessibleLevel_throwsException(){
        HotelLift hotelLift = new HotelLift();
        assertThrows(IllegalArgumentException.class, () ->
                hotelLift.activeButtons(null,-1));
    }

    @Test
    void badgeIsNullOnAccessibleLevel_givesEmptyString(){
        HotelLift hotelLift = new HotelLift();
        ArrayList<Integer> result = hotelLift.activeButtons(null, 0);
        ArrayList<Integer> expected = new ArrayList<>();

        assertEquals(expected, result);
    }

    @Test
    void badgeIsValidOnInaccessibleLevel_throwsException(){
        HotelLift hotelLift = new HotelLift();
        assertThrows(IllegalArgumentException.class, () ->
                hotelLift.activeButtons("405",5));
    }

    @Test
    void staffBadgeOnLevelMinus2_givesAllLevels_minusCurrentLevel(){
        HotelLift hotelLift = new HotelLift();
        ArrayList<Integer> result = hotelLift.activeButtons("S", -2);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        assertEquals(expected,result);
    }

    @Test
    void staffBadgeOnFloor5_givesAllLevels_minusCurrentLevel(){
        HotelLift hotelLift = new HotelLift();
        ArrayList<Integer> result = hotelLift.activeButtons("S", 5);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-2, -1, 0, 1, 2, 3, 4, 6, 7, 8, 9, 10));

        assertEquals(expected,result);
    }

    @Test
    void validBadge_givesAvailableLevels_minusCurrentLevel(){
        HotelLift hotelLift = new HotelLift();
        ArrayList<Integer> result = hotelLift.activeButtons("410", 0);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(4, 10));

        assertEquals(expected,result);
    }
    @Test
    void validBadge_givesAvailableLevels_minusCurrentLevel_anotherOne(){
        HotelLift hotelLift = new HotelLift();
        ArrayList<Integer> result = hotelLift.activeButtons("720", 7);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 10));

        assertEquals(expected,result);
    }

    @Test
    void validBadge_givesAvailableLevels_minusCurrentLevel_evenMore(){
        HotelLift hotelLift = new HotelLift();
        ArrayList<Integer> result = hotelLift.activeButtons("988", 10);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 9));

        assertEquals(expected,result);
    }



}