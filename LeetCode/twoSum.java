package LeetCode;

import java.util.HashMap;

public class twoSum {
    public static int[] twoSum(int[] numbers, int target) {

        HashMap<Integer ,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length  ; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) ,i };
            }
            map.put(numbers[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {3,2,4};

        for (int i : twoSum(numbers, 6)) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
