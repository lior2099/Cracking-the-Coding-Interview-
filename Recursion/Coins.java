package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Coins {

    /*
        Coins: Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
        pennies (1 cent), write code to calculate the number of ways of representing n cents.
     */

    public static int waysForNCent(int coin) {
        if (coin <= 0) {
            return 0;
        }
        int[] paths = {25, 10, 5, 1};
        Map<String, Integer> mem = new HashMap<>();
        return calWays(coin, paths, 0, mem);
    }

    private static int calWays(int coin, int[] paths, int index, Map<String, Integer> mem) {
        String key = coin + " " + index;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        if (coin < 0) {
            return 0;
        }
        if (coin == 0) {
            return 1;
        }
        int sumWay = 0;

        for (int i = index; i < paths.length; i++) {
            sumWay += calWays(coin - paths[i], paths, i , mem);
        }
        mem.put(key, sumWay);
        return sumWay;
    }

}
