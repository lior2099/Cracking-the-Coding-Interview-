package LeetCode;

public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {

        int num = strs.length;
        if (num == 0) return "";
        if (num == 1) return strs[0];


        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {

        String[] strs = {"i", "love", "leetcode"};
        System.out.println(longestCommonPrefix(strs));

        String[] strs1 = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs1));
    }
}
