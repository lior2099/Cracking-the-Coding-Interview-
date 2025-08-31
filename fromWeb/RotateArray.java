package fromWeb;

public class RotateArray {
    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        revers(nums, 0, nums.length - 1);
        revers(nums, 0, k - 1);
        revers(nums, k, nums.length - 1);

    }

    private static void revers(int[] arr, int start, int end) {
       while (start < end) {
           int temp = arr[start];
           arr[start] = arr[end];
           arr[end] = temp;
           start++;
           end--;
       }

    }
}
