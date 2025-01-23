package Recursion;

import java.util.HashMap;
import java.util.Map;

public class BooleanEvaluation {
    /*
    Boolean Evaluation: Given a boolean expression consisting of the symbols 0 (false), 1 (true), &
    (AND), I (OR), and /\ (XOR), and a desired boolean result value result, implement a function to
    count the number of ways of parenthesizing the expression such that it evaluates to result.
    EXAMPLE
    countEval("l /\01011", false) -> 2
    countEval("0&0&0&1/\ll0", true) -> 10
     */

    // Memoization map to store results of subproblems
    private static Map<String, Integer> memo = new HashMap<>();

    public static int countEval(String expression, boolean result) {
        // Base case: return 0 if the expression is invalid
        if (expression == null || expression.length() == 0) return 0;
        return countWays(expression, result);
    }

    private static int countWays(String expression, boolean result) {
        // If the expression is just a single value, directly return if it matches the result
        if (expression.length() == 1) {
            boolean exprValue = expression.equals("1");
            return (exprValue == result) ? 1 : 0;
        }

        // Check if result is already computed
        String key = expression + "_" + result;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ways = 0;

        // Split the expression at each operator
        for (int i = 1; i < expression.length(); i += 2) {
            char operator = expression.charAt(i); // Current operator
            String left = expression.substring(0, i); // Left subexpression
            String right = expression.substring(i + 1); // Right subexpression

            // Evaluate all combinations of left and right with true/false
            int leftTrue = countWays(left, true);
            int leftFalse = countWays(left, false);
            int rightTrue = countWays(right, true);
            int rightFalse = countWays(right, false);

            // Combine results based on the operator
            int totalWays = (leftTrue + leftFalse) * (rightTrue + rightFalse);
            int trueWays = 0;

            switch (operator) {
                case '&': // AND
                    trueWays = leftTrue * rightTrue;
                    break;
                case '|': // OR
                    trueWays = (leftTrue * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                    break;
                case '^': // XOR
                    trueWays = (leftTrue * rightFalse) + (leftFalse * rightTrue);
                    break;
            }

            // Depending on the desired result, add the appropriate ways
            ways += (result) ? trueWays : (totalWays - trueWays);
        }

        // Store result in memo
        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        // Example usage
        String expression1 = "1^0|0|1";
        boolean result1 = false;
        System.out.println("Count of ways to evaluate '" + expression1 + "' to " + result1 + ": " + countEval(expression1, result1));

        String expression2 = "0&0&0&1^1|0";
        boolean result2 = true;
        System.out.println("Count of ways to evaluate '" + expression2 + "' to " + result2 + ": " + countEval(expression2, result2));
    }
}
