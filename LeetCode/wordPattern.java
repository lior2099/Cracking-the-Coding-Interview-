package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class wordPattern {
    public static boolean wordPattern(String pattern, String s) {

//        if (pattern == null || pattern.length() == 0) {
//            return false;
//        }
//        String[] words = s.split(" ");
//
//        if (words.length != pattern.length()) {
//            return false;
//        }
//        Map<Character, String> map_PS = new HashMap<Character, String>();
//        Map<String, Character> map_SP = new HashMap<String, Character>();
//
//        int run = 0;
//
//        for (String word : words ) {
//            if (map_SP.containsKey(word)) {
//
//                char ch = map_SP.get(word);
//
//                if (ch != pattern.charAt(run)) {
//                    return false;
//                }
//
//            } else if (map_PS.containsKey(pattern.charAt(run))) {
//                return false;
//
//            } else {
//                map_SP.put(word,pattern.charAt(run));
//                map_PS.put(pattern.charAt(run),word);
//            }
//
//            run++;
//        }

//        return true;


        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> mapCharToWord = new HashMap<>();
        Map<String, Character> mapWordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (mapCharToWord.containsKey(c)) {
                if (!mapCharToWord.get(c).equals(word)) return false;
            } else {
                if (mapWordToChar.containsKey(word)) return false;
                mapCharToWord.put(c, word);
                mapWordToChar.put(word, c);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat fish";
        boolean res = wordPattern(pattern, s);
        System.out.println(res);


    }
}
