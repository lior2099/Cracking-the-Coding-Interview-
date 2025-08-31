package LeetCode;

import java.util.Stack;

public class evaluateReversePolish {
    public static int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> nums = new Stack<>();
        int num1 = 0;
        int num2 = 0;

        for (String token : tokens) {
            switch (token) {
                case "+":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    nums.push(calculations(num1, num2, "+"));
                    break;
                case "-":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    nums.push(calculations(num1, num2, "-"));
                    break;
                case "*":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    nums.push(calculations(num1, num2, "*"));
                    break;
                case "/":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    nums.push(calculations(num1, num2, "/"));
                    break;
                default:
                    nums.push(Integer.parseInt(token));
            }
        }
        return nums.peek();
    }

    private static int calculations(int nums1, int nums2, String operator) {
        if (operator.equals("+")) {
            return nums1 + nums2;
        }
        if (operator.equals("-")) {
            return nums2 - nums1;
        }
        if (operator.equals("*")) {
            return nums2 * nums1;
        }
        if (operator.equals("/")) {
            return nums2 / nums1;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
