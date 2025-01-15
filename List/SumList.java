package List;

public class SumList {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sizeList1 = getSizeList(l1);
        int sizeList2 = getSizeList(l2);
        if (sizeList1 != sizeList2){
            if (sizeList1 < sizeList2){
                l1 =  addZero(l1 , sizeList2 - sizeList1);
            } else {
                l2 = addZero(l2 , sizeList1 - sizeList2);
            }

        }

        if (addTwoNumbersHelper(l1,l2) == 1){
            ListNode newNode = new ListNode(l1.val , l1.next);
            l1.setVal(1);
            l1.next = newNode;
        }

        return  l1;
    }

    private static int addTwoNumbersHelper(ListNode l1 , ListNode l2){
        int toAdd = 0;
        if (l1.next != null && l2.next != null ){
            toAdd = addTwoNumbersHelper(l1.next , l2.next);
        }

        int sum = l1.val + l2.val + toAdd;
        if (sum > 9){
            sum = sum - 10;
            toAdd = 1;
        } else {
            toAdd = 0;
        }

        l1.setVal(sum);
        return toAdd;
    }

    private static ListNode addZero(ListNode list , int sumToAdd){
        for (int i = 0 ; i < sumToAdd ; i++){
            list = new ListNode(0 , list);
        }
        return list;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void setVal(int val){
            this.val = val;
        }
    }

    private static int getSizeList(ListNode list){
        int counter = 1;
        while (list.next != null){
            counter++;
            list = list.next;
        }

        return counter;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(3 , new ListNode(4 , new ListNode( 5 , new ListNode( 1))));
//        ListNode list2 = new ListNode(1 , new ListNode(2,  new ListNode( 4)));
        ListNode list3 = new ListNode(6 , new ListNode(5 , new ListNode( 4 , new ListNode( 9))));


        ListNode result2 = addTwoNumbers(list1,list3);

        while (result2 != null){
            System.out.print(result2.val + "->");
            result2 = result2.next;
        }

        System.out.println("null");


    }
}
