package LeetCode;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

//        Map<String, List<String>> map = new HashMap<>();
//
//        for (String str : strs) {
//            int[] count = new int[26];
//            for (char ch : str.toCharArray()) {
//                count[ch - 'a']++;
//            }
//
//            StringBuilder keyBuild = new StringBuilder();
//            for (int num : count) {
//                keyBuild.append(num).append('&');
//            }
//            String key = keyBuild.toString();
//
//            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
//        }
//
//        return new ArrayList<>(map.values());

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            map.computeIfAbsent(new String(arr), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        List<List<String>> list = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        for (List<String> list1 : list) {
            System.out.println(list1);
        }

        List<List<String>> list2 = groupAnagrams(new String[]{"ac", "d"});

        for (List<String> list3 : list2) {
            System.out.println(list3);
        }
    }


}
