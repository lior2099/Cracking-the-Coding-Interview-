package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class summaryRanges {
    public static List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int end = nums[i];

            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                end = nums[i + 1];
                i++;
            }
            if (cur == end) {
                res.add(cur + "");
            }
            else  {
                res.add(cur + "->" + end);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{1,2,3,4,6,7,8,9}));
    }

    public static class symmetricTree {
        }
}
