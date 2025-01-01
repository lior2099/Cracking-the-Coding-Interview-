package il.co.ilrd.book.Arrays;

import java.util.Arrays;

public class CheckPermutation {
    public static boolean IsPermutation(char[] str1, char[] str2) {

        if (str1.length != str2.length) {
            return false;
        }

        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[] str1 = "abcd".toCharArray();
        char[] str2 = "adcb".toCharArray();
        char[] str4 = "asdfghjklqwertyuoizxcvbnm".toCharArray();
        char[] str5 = "asdfghjklqwertyuiozxcvbnm".toCharArray();

        // Warm-up phase
        for (int i = 0; i < 2; i++) {
            IsPermutation(str1, str2);
            IsPermutation(str4, str5);
        }

        long startTime = System.nanoTime();
        boolean first = IsPermutation(str1, str2);
        long endTime = System.nanoTime();
        System.out.println("First isPermutation = " + first + ", Time: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        boolean second = IsPermutation(str4, str5);
        endTime = System.nanoTime();
        System.out.println("Second isPermutation = " + second + ", Time: " + (endTime - startTime) + " nanoseconds");
    }

}
