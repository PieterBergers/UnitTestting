package week3_OPL;

import java.util.ArrayList;

public class HotelLift {

    public ArrayList<Integer> activeButtons(String badge, int currentLevel) {
        ArrayList<Integer> active = new ArrayList<>();

        if (badge == null || badge.isEmpty()) {
            if (currentLevel != 0) {
                throw new IllegalArgumentException("Invalid level");
            } else return active;
        }
        if (currentLevel > 10 || currentLevel < -2) {
            throw new IllegalArgumentException("Invalid Level");
        }
        if ("S".equals(badge)) {
            for (int i = -2; i <= 10; i++)
                if (i != currentLevel)
                    active.add(i);
        }
        else {
            try {
                int badgeLevel = Integer.parseInt(badge);
                if (badgeLevel < 0 || badgeLevel > 999) {
                    throw new IllegalArgumentException("Invalid badge");
                }
                int badgeFloor = Integer.parseInt(badge.substring(0, 1));
                if (currentLevel != 0 && currentLevel != badgeFloor && currentLevel != 10) {
                    throw new IllegalArgumentException("You are not allowed on this floor!");
                } else
                    active.add(0);
                active.add(badgeFloor);
                active.add(10);
                active.remove((Integer) currentLevel);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid badge");
            }

        }
        return active;
    }
}