package Arrays;

public class StringCompression {
    /*
        String Compression: Implement a method to perform basic string compression using the counts
        of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
        "compressed" string would not become smaller than the original string, your method should return
        the original string. You can assume the string has only uppercase and lowercase letters (a - z)
     */

    public static String stringCompressionMe(String str){
        if (str.length() == 0){
            return "";
        }
        StringBuilder newStr = new StringBuilder();
        int counter = 1 ;
        char prev = str.charAt(0);
        newStr.append(prev);

        for (int i =1 ; i < str.length() ; i++){
            if (prev == str.charAt(i)){
                counter++;
            } else {
                if (counter > 1){
                    newStr.append(counter);
                }
                newStr.append(str.charAt(i));
                counter = 1;
            }
            prev = str.charAt(i);
        }

        if (counter >1){
            newStr.append(counter);
        }

        return newStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringCompressionMe("aabcccccaaa") );
        System.out.println(stringCompressionMe("abcd") );
        System.out.println(stringCompressionMe("") );
        System.out.println(stringCompressionMe("a") );

        System.out.println(stringCompressionMe("abbbAAABCcd") );

    }
}
