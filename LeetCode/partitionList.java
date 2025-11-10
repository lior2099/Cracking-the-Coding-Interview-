package LeetCode;

public class partitionList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode partition(ListNode head, int x) {

        ListNode cur = head;
        ListNode lessFromX = new ListNode(0);
        ListNode biggerFromX = new ListNode(0);
        ListNode dummyBig = biggerFromX;
        ListNode dummyLess = lessFromX;


        while (cur != null) {
            if (cur.val < x) {
                lessFromX.next = cur;
                lessFromX = lessFromX.next;
            } else {
                biggerFromX.next = cur;
                biggerFromX = biggerFromX.next;
            }
            cur = cur.next;
        }
        biggerFromX.next = null;
        lessFromX.next = dummyBig.next;
        return dummyLess.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(2);

        ListNode res =  new partitionList().partition(root, 3);
        for (ListNode cur = res; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }

        ListNode root2 = new ListNode(2);
        root2.next = new ListNode(1);

        ListNode res2 =  new partitionList().partition(root2, 2);
        for (ListNode cur = res2; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }

    }
}
