package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class isomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {

//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        Map<Character, Character> map_s = new HashMap<Character, Character>();
//        Map<Character, Character> map_t = new HashMap<Character, Character>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (map_s.containsKey(s.charAt(i))) {
//                if (!map_s.get(s.charAt(i)).equals(t.charAt(i))) {
//                    return false;
//                }
//            }  else {
//                if (map_t.containsKey(t.charAt(i))) {
//                    return false;
//                }
//            }
//            map_s.put(s.charAt(i), t.charAt(i));
//            map_t.put(t.charAt(i), s.charAt(i));
//        }
//
//        return true;


        if(s.length()!=t.length()) return false;

        int arr_s[]=new int[128];
        int arr_t[]=new int[128];

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            char d=t.charAt(i);

            if(arr_s[c]!=arr_t[d]){
                return false;
            }

            arr_s[c]=i+1;
            arr_t[d]=i+1;
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("a", "a"));

    }
}
