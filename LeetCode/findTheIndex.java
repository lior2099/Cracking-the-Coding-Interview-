package LeetCode;

public class findTheIndex {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        if (haystack.length() == 0) return -1;

        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "abcdefg";
        String needle = "abc";
        System.out.println(strStr(haystack, needle));

        System.out.println(strStr("leetcode", "leeto"));
    }
}
