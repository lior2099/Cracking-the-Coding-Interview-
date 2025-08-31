package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class validAnagram {
    public static boolean isAnagram(String s, String t) {

//        Map<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//        }
//
//        for (int i = 0; i < t.length(); i++) {
//            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
//        }
//
//        for (int num : map.values()) {
//            if (num != 0) return false;
//        }
//        return true;
        if (s.length() != t.length()) return false;

        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (chars[t.charAt(i) - 'a'] != 0) return false;

            chars[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("ab", "eidbaooo"));
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
