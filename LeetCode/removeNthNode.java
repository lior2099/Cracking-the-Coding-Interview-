package LeetCode;



public class removeNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode runner = dummyHead;
        ListNode slow = dummyHead;

        for (int i = 0; i <= n; i++) {
            runner = runner.next;
        }

        while (runner != null) {
            runner = runner.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode node2 = removeNthFromEnd(node1, 2) ;

        while(node2 != null){
            System.out.println(node2.val);
            node2 = node2.next;
        }
        ListNode node3 = new ListNode(1);

        ListNode node4 = removeNthFromEnd(node3, 1) ;
    }
}
