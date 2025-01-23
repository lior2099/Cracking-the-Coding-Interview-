package stacks;

import java.util.Stack;

public class SortStack {
    /*
        Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
        an additional temporary stack, but you may not copy the elements into any other data structure
        (such as an array). The stack supports the following operations: push, pop, peek, and is Empty
     */


    public static void sortStack(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();

        sortHelper(s1, s2);
    }

    private static void sortHelper(Stack<Integer> s1, Stack<Integer> s2) {
        if (s1.isEmpty()) {
            return;
        }

        int temp = s1.pop();

        while (!s2.isEmpty() && s2.peek() > temp) {
            s1.push(s2.pop());
        }

        s2.push(temp);

        sortHelper(s1, s2);

        if (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(5);
        s1.push(1);
        s1.push(4);
        s1.push(2);

        System.out.println("Original Stack: " + s1);
        sortStack(s1);
        System.out.println("Sorted Stack: " + s1);
    }

}
