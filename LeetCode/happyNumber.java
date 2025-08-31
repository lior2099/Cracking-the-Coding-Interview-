package LeetCode;

public class happyNumber {
    public static boolean isHappy(int n) {
        if (n  == 1 || n == 7) {
            return true;
        }

        while (n >= 10) {
            int length = (int) Math.log10(n) + 1;
            int[] arr = new int[length];

            for (int i = length - 1; i >= 0; i--) {
                arr[i] = n % 10;
                n /= 10;
            }

            for (int i = 0; i < arr.length; i++) {
                n += Math.pow(arr[i], 2);
            }
        }

        return n == 1 || n == 7;

//        Set<Integer> seen = new HashSet<>();
//
//        while (n != 1 && !seen.contains(n)) {
//            seen.add(n);
//            int sum = 0;
//
//            while (n > 0) {
//                int digit = n % 10;
//                sum += Math.pow(digit, 2);
//                n /= 10;
//            }
//
//            n = sum;
//        }
//
//        return n == 1;

    }

    public static void main(String[] args) {
        System.out.println(isHappy(1111111));
    }
}
