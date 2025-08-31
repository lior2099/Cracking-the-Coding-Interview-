package LeetCode;

public class bestTime {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];

        for(int p : prices){
            if(p < buy){
                buy = p;
            } else if(p - buy  > maxProfit){
                maxProfit = p - buy;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = new int[]{1,2,3,4,5};

        System.out.println(maxProfit(prices));
    }
}
