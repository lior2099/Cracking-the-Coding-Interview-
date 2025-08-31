package LeetCode;

public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        searchInsert solution = new searchInsert();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2));
    }
}
