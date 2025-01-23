package Sorting;

public class SearchInRotatedArray {
    /*
    Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
    number of times, write code to find an element in the array. You may assume that the array was
    originally sorted in increasing order.

    EXAMPLE
    lnput: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
    Output: 8 (the index of 5 in the array)
     */

    public static int searchInRotatedArray(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                // Check if target is in the left sorted half
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Right half is sorted
            else {
                // Check if target is in the right sorted half
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
        int[] UnsortedArray = new int[]{10,11,14,15 , 1,3,5,9};
        System.out.println(searchInRotatedArray(arr, 7));
        System.out.println(searchInRotatedArray(arr, 8));
        System.out.println(searchInRotatedArray(rotatedArray, 0));
        System.out.println(searchInRotatedArray(rotatedArray, 1));
        System.out.println(searchInRotatedArray(UnsortedArray, 14));
        System.out.println(searchInRotatedArray(UnsortedArray, 55));

    }
}
