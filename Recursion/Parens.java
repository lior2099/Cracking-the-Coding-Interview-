package il.co.ilrd.book.Recursion;

import java.util.ArrayList;

public class Parens {

    /*
    Parens: Implement an algorithm to print all valid (e.g., properly opened and closed) combinations
    of n pairs of parentheses.

        EXAMPLE
        Input: 3
        Output: ((() ) ) , (() () ) , (() ) () , () (() ) , () () ()
     */

    public static ArrayList<String> getAllParens(int pairs) {
        ArrayList<String> list = new ArrayList<>();
        fillAllParens(new char[pairs * 2], pairs, pairs, 0, list);
        return list;

    }

    private static void fillAllParens(char[] str, int leftPar, int rightPar, int index, ArrayList<String> list) {
        if (leftPar < 0 || rightPar < 0 || rightPar < leftPar) {
            return;
        }

        if (rightPar == 0 && leftPar == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            fillAllParens(str, leftPar - 1, rightPar, index + 1, list);

            str[index] = ')';
            fillAllParens(str, leftPar, rightPar - 1, index + 1, list);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> printList = getAllParens(3);

        for (String str : printList){
            System.out.print(str);
            System.out.print(" ");
        }
    }
}


