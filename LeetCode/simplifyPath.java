package LeetCode;

import java.util.*;

public class simplifyPath {
    public static String simplifyPath(String path) {

        if (path == null || path.isEmpty()) return "/";

        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) continue;

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";

        String[] res = path.split("/");




        System.out.println(simplifyPath(path));
    }
}
