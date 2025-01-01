package il.co.ilrd.book.List;


import il.co.ilrd.testme.testme;

import java.util.HashSet;
import java.util.Set;

public class RemoveDup {
    public static Node removeDupWithSet(Node head ){
        Set<Integer> set = new HashSet<>();

        Node runner = head;

        while (runner.hasNext()){
            if (set.contains(runner.next.value)){
                runner.next = runner.next.next;
            } else {
                set.add(runner.value);
                runner = runner.next;
            }
        }

        return head;
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
        removeDupWithSet(tree1);
        printMe(tree1 , "after the remove");

    }
}




