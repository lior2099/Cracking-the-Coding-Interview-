package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    public int longestConsecutiveQ(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int max = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                max = Math.max(max, count);
            }

        }

        return max;
    }

    public static void main(String[] args) {
        longestConsecutive sol = new longestConsecutive();
        System.out.println(sol.longestConsecutiveQ(new int[]{1,2,3,4}));
    }
}
