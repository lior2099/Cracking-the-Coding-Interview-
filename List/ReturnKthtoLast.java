package il.co.ilrd.book.List;


public class ReturnKthtoLast {
    public static Node findKfromLest(Node head , int k ){
        Node fest = head;
        Node slow = head;

        while (fest != null && k > 0 ){
            fest = fest.next;
            k--;
        }

        while (fest != null){
            fest = fest.next;
            slow = slow.next;
        }

        return slow;
    }


    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(15);
        head.next.next = new Node(20);
        head.next.next.next = new Node(30);


        System.out.println(findKfromLest(head , 3).value);

    }



    public static class Node{
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
}
