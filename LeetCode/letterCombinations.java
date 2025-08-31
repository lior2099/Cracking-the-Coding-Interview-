package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.isEmpty()) return ans;

        recLetterCombinations(digits, ans, 0,  new StringBuffer());

        return ans;
    }

    private static void recLetterCombinations(String digits, List<String> ans, int index, StringBuffer letters) {
        if (index == digits.length()) {
            ans.add(letters.toString());
            return;
        }

        String possibleLetters = getPossibleLetters(digits.charAt(index) - '0');
        for (char c :  possibleLetters.toCharArray()) {
            letters.append(c);
            recLetterCombinations(digits, ans, index + 1, letters);
            letters.deleteCharAt(letters.length() - 1);
        }
    }

    public static String getPossibleLetters(int digit) {
        switch (digit) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
        }
        return "";
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);



    }
}
