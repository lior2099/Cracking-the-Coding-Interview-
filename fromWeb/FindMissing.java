package fromWeb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMissing {
    public static int findMissingNumber(int[] arr, int n) {
        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num;
        }
        return totalSum - arraySum;
    }

    public static int findMissingAndDuplicate(int[] arr, int n) {
        int sum = n * (n + 1) / 2;
        int sumOfSquares = n * (n + 1) * (2 * n + 1) / 6;

        int actualSum = 0;
        int actualSumOfSquares = 0;

        for (int num : arr) {
            actualSum += num;
            actualSumOfSquares += num * num;
        }

        // Calculate the differences
        int diff = sum - actualSum;  // missing - duplicate
        int diffOfSquares = sumOfSquares - actualSumOfSquares;  // missing^2 - duplicate^2

        // Now, missing + duplicate can be found as (missing^2 - duplicate^2) / (missing - duplicate)
        int missingPlusDuplicate = diffOfSquares / diff;

        // Solve for missing and duplicate
        int missing = (diff + missingPlusDuplicate) / 2;
        int duplicate = missing - diff;

        return  missing;
    }


    public static void main(String[] args) {
        int[] arrMiss8 = {1, 2, 3, 4, 5, 6, 7, 9, 10};
        List<int[]> arrMiss8List = new java.util.ArrayList<>(List.of(arrMiss8));
        Collections.shuffle(arrMiss8List);

        int[] arrDup7 = {1, 2, 3, 4, 7, 6, 7 , 8, 9, 10};

        System.out.println(findMissingNumber(arrMiss8, 10));
        System.out.println(findMissingAndDuplicate(arrDup7, 10));
    }
}
