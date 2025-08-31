package LeetCode;

public class reverseWords {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        int len = words.length;

        for (int i = len -1 ; i >= 0; i--) {
            if (words[i].equals("")) {
                continue;
            }
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";

        System.out.println(reverseWords(s));
    }
}
