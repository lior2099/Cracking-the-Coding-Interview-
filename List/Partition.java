package il.co.ilrd.book.List;

public class Partition {

    public static LinkedListNode partition(LinkedListNode node, int x) {
        if (node == null) {
            return null;
        }

        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                /* Insert node at head. */
                node.next = head;
                head = node;
            } else {
                /* Insert node at tail. */
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        // The head has changed, so we need to return it to the user.
        return head;
    }


    public class LinkedListNode {
        public LinkedListNode next;
        public LinkedListNode prev;
        public LinkedListNode last;
        public int data;

        public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
            data = d;
            setNext(n);
            setPrevious(p);
        }

        public LinkedListNode(int d) {
            data = d;
        }

        public LinkedListNode() {
        }

        public void setNext(LinkedListNode n) {
            next = n;
            if (this == last) {
                last = n;
            }
            if (n != null && n.prev != this) {
                n.setPrevious(this);
            }
        }

        public void setPrevious(LinkedListNode p) {
            prev = p;
            if (p != null && p.next != this) {
                p.setNext(this);
            }
        }

        public String printForward() {
            if (next != null) {
                return data + "->" + next.printForward();
            } else {
                return ((Integer) data).toString();
            }
        }

        public LinkedListNode clone() {
            LinkedListNode next2 = null;
            if (next != null) {
                next2 = next.clone();
            }
            LinkedListNode head2 = new LinkedListNode(data, next2, null);
            return head2;
        }
    }

    public static class Node {
        Integer value;
        ReturnKthtoLast.Node next;

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

        public void setNext(ReturnKthtoLast.Node next) {
            this.next = next;
        }

    }


    public static void main(String[] args) {
        Partition partition = new Partition();

        LinkedListNode node1 = partition.new LinkedListNode(3);
        LinkedListNode node2 = partition.new LinkedListNode(5);
        LinkedListNode node3 = partition.new LinkedListNode(8);
        LinkedListNode node4 = partition.new LinkedListNode(5);
        LinkedListNode node5 = partition.new LinkedListNode(10);
        LinkedListNode node6 = partition.new LinkedListNode(2);
        LinkedListNode node7 = partition.new LinkedListNode(1);

        // Connect nodes
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);

        System.out.println("Original List: " + node1.printForward());
        Partition.LinkedListNode result = Partition.partition(node1, 5);
        System.out.println("Partitioned List (pivot=5): " + result.printForward());

        System.out.println("\n------------Test Case 1: Empty List-----------");
        System.out.println(Partition.partition(null, 3) == null ? "Pass" : "Fail");


        System.out.println("\n----------Test Case 2: Single Element Less Than Pivot--------");
        Partition.LinkedListNode singleNode = new Partition().new LinkedListNode(2);
        System.out.println("Result: " + Partition.partition(singleNode, 3).printForward());


        System.out.println("\n------------Test Case 3: Single Element Greater Than Pivot----------");
        Partition.LinkedListNode singleNode2 = new Partition().new LinkedListNode(6);
        System.out.println("Result: " + Partition.partition(singleNode2, 3).printForward());


        System.out.println("\n---------------Test Case 4: All Elements Less Than Pivot----------");
        Partition.LinkedListNode less1 = new Partition().new LinkedListNode(1);
        Partition.LinkedListNode less2 = new Partition().new LinkedListNode(2);
        less1.setNext(less2);
        System.out.println("Original: " + less1.printForward());
        System.out.println("Partitioned: " + Partition.partition(less1, 5).printForward());

        System.out.println("\n---------------Test Case 5: All Elements Greater Than Pivot------------------");
        Partition.LinkedListNode greater1 = new Partition().new LinkedListNode(6);
        Partition.LinkedListNode greater2 = new Partition().new LinkedListNode(7);
        greater1.setNext(greater2);
        System.out.println("Original: " + greater1.printForward());
        System.out.println("Partitioned: " + Partition.partition(greater1, 5).printForward());
    }
}
