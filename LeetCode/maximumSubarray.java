package LeetCode;

public class maximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        maximumSubarray sol = new maximumSubarray();
        System.out.println(sol.maxSubArray(nums));
    }
}
