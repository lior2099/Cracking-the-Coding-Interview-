package il.co.ilrd.book.Sorting;

import java.util.*;

public class GroupAnagrams {
    /*
    Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to
    each other.
     */

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Map to store sorted strings as keys and their anagrams as values
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // Sort the string alphabetically to generate a key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            // Add the original string to the corresponding anagram group
            anagramMap.putIfAbsent(sortedKey, new ArrayList<>());
            anagramMap.get(sortedKey).add(str);
        }

        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat","lior","loir","oilr" , "tba"};

        List<List<String>> result = groupAnagrams(input);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
