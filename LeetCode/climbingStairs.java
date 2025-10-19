package LeetCode;

public class climbingStairs {

    public static int climbStairs(int n) {
//        int sum = 0;
//        return climbStairsRec(n, sum);

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

//    private static int climbStairsRec(int n , int sum) {
//        if (n == 0) {
//            return sum +1;
//        }
//        if (n == 1) {
//            return sum +1 ;
//        }
//        return climbStairsRec(n - 1 , sum ) + climbStairsRec(n - 2 , sum ) ;
//    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
