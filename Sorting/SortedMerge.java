package Sorting;

import java.util.Arrays;

public class SortedMerge {
    /*
    Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
    end to hold B. Write a method to merge B into A in sorted order.
     */


    public static void mixSort(int[] arr1 , int[] arr2 , int size1 , int size2){
        int endOfArr1 = size1 - 1;
        int endOfArr2 = size2 - 1;
        int lestIndex = size1 + size2 - 1;

        while (endOfArr2 >= 0 ){
            if (endOfArr1 >= 0 && arr1[endOfArr1] > arr2[endOfArr2]){
                arr1[lestIndex--] = arr1[endOfArr1--];
            } else {
                arr1[lestIndex--] = arr2[endOfArr2--];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[10];
        arr1[0] = 1;
        arr1[1] = 5;
        arr1[2] = 9;
        arr1[3] = 10;
        arr1[4] = 12;

        int[] arr2 = {3,4,7,8,44};
        mixSort(arr1,arr2 , 5 , arr2.length);
        System.out.println(Arrays.toString(arr1));
    }
}
