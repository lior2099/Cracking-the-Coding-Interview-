

public class test {
    public int maxProfit(int[] prices) {
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

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices2 = new int[]{2,4,1};
        test test = new test();
        System.out.println(test.maxProfit(prices));
        System.out.println(test.maxProfit(prices2));
    }
}
