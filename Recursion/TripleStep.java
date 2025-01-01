package il.co.ilrd.book.Recursion;

import java.util.Arrays;

public class TripleStep {
    /*
    Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
    steps at a time. Implement a method to count how many possible ways the child can run up the
    stairs.
     */

    public static int countStep(int steps) {
        if (steps < 0) {
            return 0;
        }
        if (steps == 0) {
            return 1;
        }

        return countStep(steps - 1) + countStep(steps - 2) + countStep(steps - 3);
    }

    public static int countStepCashe(int steps) {
        return countStepCasheHelper(steps, new int[steps + 1]);
    }

    private static int countStepCasheHelper(int steps, int[] memo) {
        if (steps < 0) {
            return 0;
        }
        if (steps == 0) {
            return 1;
        }

        if (memo[steps] == 0) {
            memo[steps] = countStepCasheHelper(steps - 1, memo) +
                    countStepCasheHelper(steps - 2, memo) +
                    countStepCasheHelper(steps - 3, memo);
        }

        return memo[steps];
    }


    public static int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private static int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) +
                    countWays(n - 3, memo);
            return memo[n];
        }
    }

    public static void main(String[] args) {
//        System.out.println(countStep(10));
//        System.out.println(countStepCashe(10));
        int size = 30;


        // Warm-up phase
        for (int i = 0; i < 10; i++) {
            countStep(size);
            countStepCashe(size);
            countWays(size);
        }

        long startTime = System.nanoTime();
        int first = countStepCashe(size);
        long endTime = System.nanoTime();
        System.out.println("First countStepCashe = " + first + ", Time: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        int second = countWays(size);
        endTime = System.nanoTime();
        System.out.println("Second countWays = " + second + ", Time: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        int trhee = countStep(size);
        endTime = System.nanoTime();
        System.out.println("Second countStep = " + trhee + ", Time: " + (endTime - startTime) + " nanoseconds");


    }
}
