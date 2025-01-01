package il.co.ilrd.book.Arrays;

public class URLify {
    /*
    URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
    has sufficient space at the end to hold the additional characters,and that you are given the "true"
    length of the string. (Note: If implementing in Java, please use a character array so that you can
    perform this operation in place.)
    EXAMPLE
    Input: "Mr John Smith ", 13
    Output: "Mr%20John%20Smith"


     */


    public static void makeURL(char[] str, int size) {


        int end = size - 1 + howMuchSpaces(str , size -1)*2;

        for (int i = size - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                replaceSpaces(str, end);
                end = end - 3 ;
            } else {
                str[end] = str[i];
                end--;
            }

        }
    }

    private static int howMuchSpaces(char[] str , int size){
        int counter = 0;
        while (size > 0){
            if (str[size] == ' '){
                counter++;
            }
            size--;
        }
        return counter;
    }

    private static void replaceSpaces(char[] str , int index){
        str[index] = '0';
        str[index-1] = '2';
        str[index-2] = '%';
    }

    public static void main(String[] args) {

        char[] str = "Mr John Smith         ".toCharArray();

        for (int i = 0 ; i < 13 ; i++){
            System.out.print(str[i]);
        }

        System.out.println(" ");

        makeURL(str , 13);
        for (int i = 0 ; i < 16 ; i++){
            System.out.print(str[i]);
        }


    }
}
