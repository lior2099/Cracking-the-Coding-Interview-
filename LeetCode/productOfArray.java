package LeetCode;

public class productOfArray {
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] res = new int[len];

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 1;
        right[len-1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }

        return res;

    }

    public static void main(String[] args) {
        productOfArray obj = new productOfArray();
        int[] res = obj.productExceptSelf(new int[]{1,2,3,4});

        for (int i : res) {
            System.out.print(i + " ");
        }

    }
}
