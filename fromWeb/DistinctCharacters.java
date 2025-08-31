package fromWeb;

import java.util.LinkedHashMap;
import java.util.Map;

public class DistinctCharacters {

    public static String PrintDistinctCharacters(String str) {
        if (str == null) {
            return "";
        }

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder res = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res.append(entry.getKey());
            }
        }

        return res.toString();
    }


    public static void main(String[] args) {

        String str1 = "Geeks for Geeks";
        String str2 = "Hello Geeks";
        String str3 = "dude where is my car";


        System.out.println("Original String: " + str1);
        System.out.println(PrintDistinctCharacters(str1));

        System.out.println("Original String: " + str2);
        System.out.println(PrintDistinctCharacters(str2));

        System.out.println("Original String: " + str3);
        System.out.println(PrintDistinctCharacters(str3));


    }
}
