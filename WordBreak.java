package il.co.ilrd.book;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak {

    public static boolean canSegment(String str, Set<String> dic) {
        int size = str.length();
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dic.contains(str.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[size];
    }


    public static boolean wordBreak(String str, Set<String> dict) {
        return wordBreakHelper(str, dict, new HashMap<>());
    }

    private static boolean wordBreakHelper(String str, Set<String> dict, Map<String, Boolean> memo) {
        // If the string is empty, return true
        if (str.isEmpty()) {
            return true;
        }

        // Check if we have already computed this substring
        if (memo.containsKey(str)) {
            return memo.get(str);
        }

        // Try each word in the dictionary
        for (String word : dict) {
            if (str.startsWith(word)) {
                String remaining = str.substring(word.length());
                if (wordBreakHelper(remaining, dict, memo)) {
                    memo.put(str, true);
                    return true;
                }
            }
        }

        // If no word matches, store false and return
        memo.put(str, false);
        return false;
    }

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("cat");
        dictionary.add("cats");
        dictionary.add("pie");
        dictionary.add("apple");
        dictionary.add("pen");


        String str1 = "catcatscatcat";
        String str2 = "applepiepen";
        String str3 = "applepenpine";


        System.out.println("Can segment \"" + str1 + "\": " + canSegment(str1, dictionary)); // true
        System.out.println(wordBreak(str1,dictionary));
        System.out.println("Can segment \"" + str2 + "\": " + canSegment(str2, dictionary)); // true
//        System.out.println("Can segment \"" + str3 + "\": " + canSegment(str3, dictionary)); // false
    }
}