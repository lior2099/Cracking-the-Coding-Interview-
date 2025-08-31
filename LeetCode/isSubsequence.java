package LeetCode;

public class isSubsequence {
    public static boolean isSubsequence(String s, String t) {

        int run = 0;
        int check = 0;

        while (check < s.length() && run < t.length()) {

            if (s.charAt(check) == t.charAt(run)) {
                check++;
            }

            run++;
        }

        return check == s.length();

    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }
}
