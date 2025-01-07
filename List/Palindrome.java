package il.co.ilrd.book.List;

import java.util.Stack;

public class Palindrome {
    /*
    Palindrome: Implement a function to check if a linked list is a palindrome.
     */

    public static boolean IsListPalindrome(Node head){
        Stack<Character> stack = getStack(head);

        while (head != null){
            if (head.value != stack.pop()){
                return false;
            }
            head = head.next;
        }


        return true;
    }

    private static Stack<Character> getStack(Node head){
        Stack<Character> stack = new Stack<>();

        while (head != null){
            stack.push(head.value);
            head = head.next;
        }

        return stack;
    }

    public static boolean IsListPalindromebetter(Node head){
        Stack<Character> stack = new Stack<>();
        Node fest = head;
        Node slow = head;

        while (fest != null && fest.hasNext()){
            stack.push(slow.value);
            slow = slow.next;
            fest = fest.next.next;

        }

        if (fest != null){ // if odd number
            slow = slow.next;
        }



        while (slow != null){
            if (slow.value != stack.pop()){
                return false;
            }
            slow = slow.next;
        }


        return true;
    }



    private static class Node {
        Character value;
        Node next;

        public Node(Character value) {
            this.value = value;
            this.next = null;
        }

        public boolean hasNext() {
            return !(next == null);
        }

        public int getValue() {
            return value;
        }

        public void setValue(Character value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {
        Node tree1 = new Node('a');
        tree1.next = new Node('a');
        tree1.next.next = new Node('b');
        tree1.next.next.next = new Node('a');
        tree1.next.next.next.next = new Node('a');

        System.out.println(IsListPalindrome(tree1));
        System.out.println(IsListPalindromebetter(tree1));

    }
}
