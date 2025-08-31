package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class twoSum2 {
    public static int[] twoSum(int[] numbers, int target) {

        int big =numbers.length - 1;
        int small = 0;

        while (small < big) {
            if (numbers[small] + numbers[big] == target) {
                return new int[]{small + 1, big + 1};
            }
            if (numbers[small] + numbers[big] < target) {
                small++;
                continue;
            }
            if (numbers[small] + numbers[big] > target) {
                big--;
                continue;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,4};

       for (int i : twoSum(numbers, 6)) {
           System.out.print(i);
           System.out.print(" ");
       }
    }
}
