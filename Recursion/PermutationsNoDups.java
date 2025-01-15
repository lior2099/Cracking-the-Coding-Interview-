package Recursion;

import java.util.Arrays;
import java.util.LinkedList;

public class PermutationsNoDups {
    /*/
        Permutations without Dups: Write a method to compute all permutations of a string of unique
        characters.
     */

    public static LinkedList<String> PrintPermutations(char[] str){
        LinkedList<String> list = new LinkedList<>();

        PermutationsHelper(str , 0 , str.length -1  ,list);

        return list;
    }

    private static void PermutationsHelper(char[] str , int start , int end , LinkedList<String> list  ){

        if (start == end){
            list.add(Arrays.toString(str));
            return;
        }

        for (int i = start ; i <= end ; i++){
            swapChar(str , i , start );
            PermutationsHelper(str, start + 1 , end , list);
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

        LinkedList<String> printList = PrintPermutations(word);

        for (String str : printList){
            System.out.println(str);
        }
    }
}
