package Recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PermutationsWithDups {
    /*/
        Permutations with Dups: Write a method to compute all permutations of a string whose
        characters are not necessarily unique. The list of permutations should not have duplicates
     */

    public static  Set<String> PrintPermutations(char[] str){
        Set<String> set = new HashSet<>();

        PermutationsHelper(str , 0 , str.length -1  ,set);

        return set;
    }

    private static void PermutationsHelper(char[] str , int start , int end , Set<String> set  ){

        if (start == end){
            if (!set.contains(str)){
                set.add(Arrays.toString(str));
            }
            return;
        }

        for (int i = start ; i <= end ; i++){
            swapChar(str , i , start );
            PermutationsHelper(str, start + 1 , end , set);
            swapChar(str , i , start );
        }
    }

    private static void swapChar(char[] str , int index1 , int index2){
        char temp = str[index1];
        str[index1] = str[index2];
        str[index2] = temp;
    }

    public static void main(String[] args) {
        char[] word = "abb".toCharArray();

        Set<String> printList = PrintPermutations(word);

        for (String str : printList){
            System.out.println(str);
        }
    }
}
