package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ransomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
//        Map<Character,Integer> mep = new HashMap<>();
//
//        for (char c : magazine.toCharArray()) {
//            mep.put(c,mep.getOrDefault(c,0)+1);
//        }
//
//        for (char c : ransomNote.toCharArray()) {
//            int count = mep.getOrDefault(c,0);
//            if (count == 0) {
//                return false;
//            }
//            mep.put(c,count -1);
//
//        }
//        return true;

        int[] lastIndex = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int ind = magazine.indexOf(c, lastIndex[c - 'a']);
            if (ind == -1) {
                return false;
            }
            lastIndex[c - 'a'] = ind + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aa"));
        System.out.println(canConstruct("aa", "ab"));
    }
}
