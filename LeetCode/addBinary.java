package LeetCode;

public class addBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int lenA = a.length() -1;
        int lenB = b.length() -1;

        int carry = 0;

        while (lenA >= 0 || lenB >= 0 || carry > 0) {
            int sum = carry;

            if (lenA >= 0) sum += a.charAt(lenA--) - '0';
            if (lenB >= 0) sum += b.charAt(lenB--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }



        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        addBinary aa = new addBinary();

        System.out.println(aa.addBinary(a,b));
    }
}
