package fromWeb;

public class SumStringCheck {
    public static boolean isSumString(String str) {
        int n = str.length();
        for (int i = 1; i <= n / 2; i++) { // First number length
            for (int j = i + 1; j < n; j++) { // Second number length
                if (checkSumString(str, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkSumString(String str, int start, int mid, int end) {
        String num1 = str.substring(start, mid);
        String num2 = str.substring(mid, end);

        if ((num1.startsWith("0") && num1.length() > 1) || (num2.startsWith("0") && num2.length() > 1)) {
            return false; // Avoid numbers with leading zeros
        }

        String sum = String.valueOf(Long.parseLong(num1) + Long.parseLong(num2));

        if (!str.startsWith(sum, end)) {
            return false;
        }

        int nextIndex = end + sum.length();
        if (nextIndex == str.length()) {
            return true;
        }

        return checkSumString(str, mid, end, nextIndex);
    }

    public static void main(String[] args) {
        System.out.println(isSumString("12243660")); // true
        System.out.println(isSumString("1111112223")); // true
        System.out.println(isSumString("123456")); // false
    }
}

