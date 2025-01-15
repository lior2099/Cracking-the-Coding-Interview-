package List;

public class LoopDetection {

    /*
    Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
    beginning of the loop.
    DEFINITION
    Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
    as to make a loop in the linked list.

    EXAMPLE
    Input:  A -> B -> C -> D -> E -> C [the same C as earlier]
    Output:  C
     */

    public static Node findLoop(Node head) {
        Node slow = head;

        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null ||  fast.next == null) {
            return null;
        }

        // to find the start point
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }



        return slow;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = head.next.next; // loop from 8 to 3

        System.out.println(findLoop(head).value);

    }


    private static class Node {
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
            this.next = null;
        }

        public boolean hasNext() {
            return !(next == null);
        }

        public int getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}
