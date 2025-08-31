package LeetCode;

import List.SumList;

import java.util.Stack;

public class reverseLinked {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }

        ListNode runner = start.next;
        Stack<ListNode> stack = new Stack<>();

        for (int i = 0; i <= right - left; i++) {
            stack.push(runner);
            runner = runner.next;
        }

        while (!stack.isEmpty()) {
            start.next = stack.pop();
            start = start.next;
        }

        start.next = runner;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode res = reverseBetween(head,2,4);

        for (ListNode cur = res; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
    }


}
