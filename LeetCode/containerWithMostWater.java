package LeetCode;

public class containerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;

        int sum = 0;

        while (left < right) {
            sum = Integer.min(height[left], height[right]) * (right - left);

            if (sum > max) {
                max = sum;
            }

            if (height[left] < height[right]) {
                left++;
            } else  {
                right--;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        containerWithMostWater c = new containerWithMostWater();
        System.out.println(c.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
