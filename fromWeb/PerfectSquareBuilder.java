package fromWeb;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquareBuilder {

    public static void main(String[] args) {
        int line1 = 50; // Length of line 1
        int line2 = 99;  // Length of line 2

        int largestSquare = findLargestSquareSize(line1, line2);
        System.out.println("Largest square size: " + largestSquare);


    }

    private static int findLargestSquareSize(int line1, int line2) {
        int big = Math.max(line1, line2);
        int small = Math.min(line1, line2);

        float deff = (float) big / small;

        if (deff >= 4f) {
            return big/4;
        }
        else if(deff >= 3f) {
            return small;
        }
        else if (deff >= 3/2f) {
            return big/3;
        }
        else {
            return small/2;
        }

    }


}