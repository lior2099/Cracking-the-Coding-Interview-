package Arrays;

public class StringRotation {
    /*
        String Rotation: Assume you have a method i 5Su b 5 tr ing which checks if one word is a substring
        of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
        call to i5Sub5tring (e.g., "waterbottle" is a rotation of"erbottlewat").
     */


    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        String str1str1 = s1 + s1;
        return str1str1.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        if (isRotation(s1, s2)) {
            System.out.println(s2 + " is a rotation of " + s1);
        } else {
            System.out.println(s2 + " is not a rotation of " + s1);
        }

        System.out.println(" ");

        String s3 = "coldcat";
        String s4 = "catcold";

        if (isRotation(s3, s4)) {
            System.out.println(s4 + " is a rotation of " + s3);
        } else {
            System.out.println(s4 + " is not a rotation of " + s3);
        }


    }
}
