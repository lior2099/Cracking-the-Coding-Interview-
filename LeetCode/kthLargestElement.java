package LeetCode;

import java.util.PriorityQueue;

public class kthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        int run = -1;
//
//
//        while (k > 0) {
//            int index = 0;
//            int max = Integer.MIN_VALUE;
//            run++;
//            for (int i = run; i < len; i++) {
//                if (nums[i] > max) {
//                    max = nums[i];
//                    index = i;
//                }
//
//            }
//            int temp = nums[run];
//            nums[run] =  max;
//            nums[index] = temp;
//            k--;
//        }
//        return nums[run];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int [] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
}
