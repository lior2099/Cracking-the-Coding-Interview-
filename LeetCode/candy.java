package LeetCode;

import java.util.*;

public class candy {
    public static int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int len = ratings.length;
        int[] candyArrry = new int[len];
        Arrays.fill(candyArrry, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyArrry[i] = candyArrry[i -1] + 1;
            }
        }

        int res = 0;

        for (int i = len - 2 ; i >= 0; i-- ) {
            if (ratings[i] > ratings[i + 1]) {
                candyArrry[i] = Math.max(candyArrry[i], candyArrry[i + 1] + 1);
            }
            res += candyArrry[i];
        }


        return res + candyArrry[len - 1];
    }

    public static void main(String[] args) {

        int[] ratings = {1,0,2};

        System.out.println(candy(ratings));
    }
}
