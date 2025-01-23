package fromWeb;

public class CandyDistribution {

    public static int candies(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // First pass: Initialize each child with 1 candy
        // and check left to right
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            candies[i] = 1;
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Second pass: Check right to left and take maximum
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate total candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }


    public static int recCandies(int[] ratings) {

        int n = ratings.length;
        int[] candies = new int[n];

        recHelper(ratings , candies , 0 , n);

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;

    }

    private static void recHelper(int[] ratings , int[] candies , int start, int end) {
        if (start >= end) {
            return;
        }

        candies[start] = 1;
        if (start > 0 && ratings[start] > ratings[start - 1]) {
            candies[start] = candies[start - 1] + 1;
        }

        recHelper(ratings, candies, start + 1, end);

        if (start < end - 1 && ratings[start] > ratings[start + 1]) {
            candies[start] = Math.max(candies[start], candies[start + 1] + 1);
        }

    }



    // Test the solution
    public static void main(String[] args) {

        // Test cases
        int[][] testCases = {
                {1, 0, 2},           // Expected: 5 (2,1,2)
                {1, 2, 2},           // Expected: 4 (1,2,1)
                {1, 3, 2, 2, 1},       // Expected: 7 (1,2,1,2,1)
                {1, 2, 87, 87, 87, 2, 1}, // Expected: 13 (1,2,3,1,3,2,1)
                {55, 40, 13, 2, 1, 0, 1, 0, 1}, // Expected: 26 (6,5,4,3,2,1,2,1,2)
                {1 , 1 , 1 , 1} // Expected: 4 (1,1,1,1)
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = candies(testCases[i]);
            System.out.print("Test case " + (i + 1) + ": ");
            System.out.print("Ratings = ");
            for (int rating : testCases[i]) {
                System.out.print(rating + " ");
            }
            System.out.println("\nMinimum candies needed: " + result);
            System.out.println();
        }



        System.out.println(recCandies(testCases[4]));
    }

}
