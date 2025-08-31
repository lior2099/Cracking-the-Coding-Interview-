package LeetCode;

public class rotateList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0 ) {
            return head;
        }

        int len = 1 ;
        ListNode cur = head;


        while (cur.next != null) {
            len++;
            cur = cur.next;
        }

        k =  k % len;

        if (k == 0){
            return head;
        }

        cur.next = head;

        int step = len - k;

        ListNode newTail = head;

        for (int i = 1; i < step; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;

    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        ListNode afterRotate = rotateRight(head, 3);
        while (afterRotate != null) {
            System.out.print(afterRotate.val + " ");
            afterRotate = afterRotate.next;
        }
    }
}
