package Recursion;

public class MagicIndex {
    /*
    Magic Index: A magic index in an array A [ 0••• n -1] is defined to be an index such that A[ i] =
    i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
    array A.
    FOLLOW UP
    What if the values are not distinct?
     */

    public static int getMagicIndex(int[] arr) {
        return getMagicIndexHelper(arr, 0, arr.length - 1);
    }

    private static int getMagicIndexHelper(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == mid){
            return mid;
        }
        if (arr[mid] > mid){
            return getMagicIndexHelper(arr, start , mid -1);
        } else {
            return getMagicIndexHelper(arr, mid +1 , end);
        }
    }


    public static int getMagicIndexWithDelicto(int[] arr) {
        return getMagicIndexWithDelictoHelper(arr, 0, arr.length - 1);
    }

    private static int getMagicIndexWithDelictoHelper(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midValue = arr[mid];
        if (midValue == mid){
            return mid;
        }

        int leftIndex = Math.min(mid -1 , midValue);
        int left = getMagicIndexWithDelictoHelper(arr,start , leftIndex);
        if (left >= 0 ){
            return left;
        }

        int rightIndex = Math.max(mid + 1 , midValue);
        return getMagicIndexWithDelictoHelper(arr,rightIndex , end);

    }




    public static void main(String[] args) {
        int[] arr = {-40,-15,-5,0,1,3,4,5,6,9,15,44,200};
        int[] array = {-10, -5, 2, 2, 2, 3, 4, 7, 9};


        System.out.println(getMagicIndex(arr));
        System.out.println(getMagicIndexWithDelicto(array));
    }
}
