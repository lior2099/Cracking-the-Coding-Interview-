package il.co.ilrd.book.List;

public class DeleteMiddleNode {
    /*
    Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
    the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
    that node.

    EXAMPLE

    lnput:the node c from the linked lista->b->c->d->e->f
    Result: nothing is returned, but the new linked list looks likea->b->d->e- >f

     */

    public static void removeMid(Node curr){

        curr.value = curr.next.value;
        curr.next = curr.next.next;
    }

    private static class Node{
        Integer value;
        Node next;

        public Node(Integer value){
            this.value = value;
            this.next = null;
        }

        public boolean hasNext(){
            return !(next == null);
        }

        public int getValue(){
            return value;
        }

        public void setValue(Integer value){
            this.value = value;
        }
        public void setNext(Node next){
            this.next = next;
        }

    }

    private static void printMe(Node node , String text){

        System.out.println(text);
        while (node != null){
            System.out.print(node.value);
            node = node.next;
            System.out.print("->");
        }
        System.out.println("NULL");

    }

    public static void main(String[] args) {
        Node tree1 = new Node(10);
        tree1.next = new Node(20);
        tree1.next.next = new Node(30);
        tree1.next.next.next = new Node(40);
        tree1.next.next.next.next= new Node(20);
        tree1.next.next.next.next.next= new Node(10);

        printMe(tree1 , "before the remove");
        removeMid(tree1.next.next);
        printMe(tree1 , "after the remove");

    }
}
