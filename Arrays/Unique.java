package Arrays;

import java.util.HashSet;

public class Unique {
    public static boolean isUniqueNoSpace(String str){
        /*
        time O(n^2)
        space O(1)
         */

        if (str.length() >256) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }

        return true;
    }


    public static boolean isUnique(String str){
        if (str.length() >256) {
            return false;
        }
        HashSet<Character> stringSet = new  HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            if (stringSet.contains(str.charAt(i))){
                return false;
            } else {
              stringSet.add( str.charAt(i));
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "asdfghjkl;'qwertyuiop[]zxcvbnm,./1234567890ASDFGHJKL:ZXCVBNM<>QWERTYUIOP";
        String str2 = "123@$#$(@*";

        System.out.println("With extra space:");
        long startTime = System.nanoTime();
        System.out.println(isUnique(str1));
        System.out.println(isUnique(str2));
        long endTime = System.nanoTime();
        System.out.println("Execution time (isUnique): " + (endTime - startTime) + " nanoseconds");

        System.out.println("\nWith no extra space:");
        startTime = System.nanoTime();
        System.out.println(isUniqueNoSpace(str1));
        System.out.println(isUniqueNoSpace(str2));
        endTime = System.nanoTime();
        System.out.println("Execution time (isUniqueNoSpace): " + (endTime - startTime) + " nanoseconds");
    }
}
