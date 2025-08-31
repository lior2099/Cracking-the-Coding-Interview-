package LeetCode;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        String str1 = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            if (str1.charAt(left) != str1.charAt(right)){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    public static void main(String[] args) {

        ValidPalindrome leetCode = new ValidPalindrome();
        System.out.println(leetCode.isPalindrome("a"));

        System.out.println(leetCode.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
