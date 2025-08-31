import java.util.Stack;

public class validParentheses {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpenParenthese(c)){
                stack.push(c);
            }
            else if (isCloseParenthese(c)){
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (! ((pop == '{' && c == '}' ) || (pop == '[' && c == ']' ) || (pop == '(' && c == ')' ))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isOpenParenthese(char c) {
        if  (c == '{' || c == '[' || c == '(') {
            return true;
        }
        return false;
    }

    public static boolean isCloseParenthese(char c) {
        if  (c == '}' || c == ']' || c == ')') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
    }
}
