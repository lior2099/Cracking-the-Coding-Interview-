package LeetCode;

public class trappingRainWater {

    public int trap(int[] height) {
       int left = 0 ;
       int right = height.length -1 ;
       int maxLeft = 0 ;
       int maxRight = 0 ;
       int res = 0;

       while(left < right){
           if(height[left] < height[right]){
               if(height[left] < maxLeft){
                   res += maxLeft - height[left];
               } else {
                   maxLeft = height[left];
               }

               left++;
           } else {
               if(height[right] < maxRight){
                   res += maxRight - height[right];
               } else  {
                   maxRight = height[right];
               }
               right--;
           }
       }

       return res;
    }

    public static void main(String[] args) {
        trappingRainWater r = new trappingRainWater();
        int []  arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(r.trap(arr));

    }
}
