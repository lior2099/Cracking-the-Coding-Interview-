package il.co.ilrd.book.Arrays;

public class OneAway {
    /*
    One Away: There are three types of edits that can be performed on strings: insert a character,
    remove a character, or replace a character. Given two strings, write a function to check if they are
    one edit (or zero edits) away.

        EXAMPLE
        pale, ple -> true
        pales, pale -> true
        pale, bale -> true
        pale, bake -> false

     */

    public static boolean isOneAway(String str1 , String str2){
        int size1 = str1.length();
        int size2 = str2.length();


        if (size1 == size2 ){
            return isCanEditOne(str1, str2);
        } else if (size1 -1 == size2){
            return isCanAddOne(str1 , str2);
        } else if (size2 -1 == size1){
            return isCanAddOne(str2 , str1);
        }

        return false;
    }


    private static boolean isCanAddOne(String str1 , String str2){
        int size1 = str1.length() -1;
        int size2 = str2.length() -1;

        int index1 = 0;
        int index2 = 0;

        boolean moreThenOne = false;

        while (index1 < size1 && index2 < size2){
            if (str1.charAt(index1) != str2.charAt(index2)){
                if (moreThenOne){
                    return false;
                }

                moreThenOne = true;
                index1++;
            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

    private static boolean isCanEditOne(String str1 , String str2){
        boolean oddOne = false;

        for (int i = 0 ; i < str1.length() ; i++){
            if (str1.charAt(i) != str2.charAt(i) ){
                if (oddOne){
                    return false;
                }
                oddOne = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOneAway("pale" , "ple"));
        System.out.println(isOneAway("pale" , "pale"));
        System.out.println(isOneAway("pale" , "bale"));
        System.out.println(isOneAway("pale" , "bake"));

        System.out.println(isOneAway("", "")); // true (both are empty)
        System.out.println(isOneAway("a", "")); // true (remove 'a')
        System.out.println(isOneAway("", "a")); // true (add 'a')
        System.out.println(isOneAway("a", "b")); // true (replace 'a' with 'b')
        System.out.println(isOneAway("a", "ab")); // true (add 'b')
        System.out.println(isOneAway("ab", "a")); // true (remove 'b')
        System.out.println(isOneAway("a", "abc")); // false (two edits)
    }
}
