package LeetCode;

public class removeDuplicatesFromSortedList2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-10);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = head;

        int flagFoundDup = 0;
        while (cur != null) {

            if ( cur.next != null && cur.next.val == cur.val) {
                flagFoundDup = 1;
            }
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (flagFoundDup == 1) {
                prev.next = cur.next;
                flagFoundDup = 0;
            } else {
                prev = cur;
            }

            cur = cur.next;


        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode result = deleteDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);

        ListNode result2 = deleteDuplicates(head2);
        while (result2 != null) {
            System.out.println(result2.val);
            result2 = result2.next;
        }
    }
}
