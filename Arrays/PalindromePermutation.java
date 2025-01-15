package Arrays;

import java.util.HashMap;

public class PalindromePermutation {
    /*

    Palindrome Permutation: Given a string, write a function to check if it is a permutation of
    palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
    is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

        EXAMPLE
        Input: Tact Coa
        Output: True (permutations: "taco cat", "atco cta", etc.)
     */


    public static boolean havePalindrome(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        String lower = str.toLowerCase();
        boolean oddOne = false;

        for (int i = 0 ; i < lower.length() ; i++){
            if (!(lower.charAt(i) == ' ')){
                map.merge(lower.charAt(i) , 1 , Integer::sum);
            }
        }

        Integer[] valuse = map.values().toArray(new Integer[0]);

        for (Integer num : valuse){
            if (num % 2 == 1){
                if (oddOne){
                    return false;
                }
                oddOne = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(havePalindrome("Tact Coa")); // Expected: true
        System.out.println(havePalindrome("Not a palindrome")); // Expected: false
        System.out.println(havePalindrome("")); // Expected: true (empty string is trivially a palindrome)
        System.out.println(havePalindrome("A")); // Expected: true (single character is a palindrome)
    }
}
