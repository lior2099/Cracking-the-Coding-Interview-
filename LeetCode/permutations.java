package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        recursion(nums,0, nums.length , res);
        return res;

    }

    private void recursion(int[] nums, int start , int end, List<List<Integer>> res ) {
        if (start == end) {
            res.add(makeList(nums));
            return;
        }
        for (int i = start; i < end; i++) {
            swap(nums, start, i);
            recursion(nums, start + 1, end, res);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static List<Integer> makeList(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permutations p = new permutations();
        List<List<Integer>> res = p.permute(nums);
        System.out.println(res);
    }
}
