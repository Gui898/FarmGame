package models.events;

import java.util.*;

public class Climate {

    private static final int maxValue = 50;

    public static void climateEvent(int num){

        Set<Integer> rainNums = new HashSet<>();
        Set<Integer> dryNums = new HashSet<>();
        Set<Integer> hailNums = new HashSet<>();

        double percent15 = 0.15 * maxValue;
        double percent10 = 0.1 * maxValue;
        double percent5 = 0.05 * maxValue;

        for (int i = 0; i < (int) percent15; i++) {
            rainNums.add(new Random().nextInt(maxValue)+1);
        }

        for (int i = 0; i < (int) percent10; i++) {
            dryNums.add(new Random().nextInt(maxValue)+1);
        }

        for (int i = 0; i < percent5; i++) {
            hailNums.add(new Random().nextInt(maxValue)+1);
        }

        dryNums.removeIf(rainNums::contains);
        hailNums.removeIf(rainNums::contains);
        hailNums.removeIf(dryNums::contains);

        if(rainNums.contains(num)){
            System.out.println("\n***It's raining!! +20% in productivity***");
        } else if (dryNums.contains(num)) {
            System.out.println("\n***It's drying!! -30% in productivity***");
        }else if (hailNums.contains(num)) {
            System.out.println("\n***It's hailing!! -50% on harvest***");
        }

    }

    public static int getMaxValue() {
        return maxValue;
    }
}
