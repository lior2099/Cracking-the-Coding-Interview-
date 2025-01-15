package List;

public class Intersection {

        public static Node FindIntersection(Node n1, Node n2) {
        int size1 = getSize(n1);
        int size2 = getSize(n2);

        Node longOne = size1 > size2 ? n1 : n2;
        Node smallOne = size1 > size2 ? n2 : n1;

        while (size1 > size2) {
            longOne = longOne.next;
            size1--;
        }

        while (longOne.hasNext() && smallOne.hasNext() && longOne != smallOne) {
            longOne = longOne.next;
            smallOne = smallOne.next;
        }

        return longOne == smallOne ? longOne : null ;
    }


    private static int getSize(Node n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }

        return size;


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


    public static void main(String[] args) {

        // Test case 1: Intersection at the middle
        Node common1 = new Node(8);
        common1.setNext(new Node(10));

        Node head1a = new Node(3);
        head1a.setNext(new Node(6));
        head1a.next.setNext(common1);

        Node head2a = new Node(4);
        head2a.setNext(common1);

        testFindIntersection(head1a, head2a, "Test Case 1");

        // Test case 2: Intersection at the end
        Node common2 = new Node(15);

        Node head1b = new Node(7);
        head1b.setNext(new Node(12));
        head1b.next.setNext(common2);

        Node head2b = new Node(5);
        head2b.setNext(common2);

        testFindIntersection(head1b, head2b, "Test Case 2");

        // Test case 3: No intersection
        Node head1c = new Node(1);
        head1c.setNext(new Node(2));
        head1c.next.setNext(new Node(3));

        Node head2c = new Node(4);
        head2c.setNext(new Node(5));
        head2c.next.setNext(new Node(6));

        testFindIntersection(head1c, head2c, "Test Case 3");

        // Test case 4: Longer lists with intersection
        Node common3 = new Node(20);
        common3.setNext(new Node(25));

        Node head1d = new Node(11);
        head1d.setNext(new Node(12));
        head1d.next.setNext(new Node(13));
        head1d.next.next.setNext(common3);

        Node head2d = new Node(14);
        head2d.setNext(new Node(15));
        head2d.next.setNext(common3);
    }

    private static void testFindIntersection(Node n1, Node n2, String testCase) {
        Node intersection = FindIntersection(n1, n2);
        System.out.println(testCase + ":");
        if (intersection != null) {
            System.out.println("  Intersection at node with value: " + intersection.value);
        } else {
            System.out.println("  No intersection found.");
        }
    }
}