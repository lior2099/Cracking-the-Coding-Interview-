package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> mapForT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapForT.put(t.charAt(i), mapForT.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> mapForRun = new HashMap<>();

        int left = 0;
        int right = 0;
        int mapSize = mapForT.size();
        int found = 0;

        int[] ans = {-1,0,0};

        while (right < s.length()) {
            char c = s.charAt(right);
            mapForRun.put(c, mapForRun.getOrDefault(c, 0) + 1);

            if (mapForT.containsKey(c) && mapForT.get(c).intValue() == mapForRun.get(c).intValue()) {
                found++;
            }

            while (left <= right && found == mapSize) {
                char c1 = s.charAt(left);

                // update the window if need
                if(ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                mapForRun.put(c1, mapForRun.get(c1) - 1);
                //need to make sure the we lower the found when we have less on the map
                if (mapForT.containsKey(c1) && mapForT.get(c1).intValue() > mapForRun.get(c1).intValue()) {
                    found--;
                }

                left++;
            }

            right++;
        }


        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }
}
