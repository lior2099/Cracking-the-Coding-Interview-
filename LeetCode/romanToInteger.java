package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class romanToInteger {

   static Map<Character, Integer> map = new HashMap<>();

    static  {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }


    public int romanToInt(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int sum = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            int num = mapCtoI.get(s.charAt(i));
//
//            if (i +1 <  s.length()) {
//                int nextNum = mapCtoI.get(s.charAt(i+1));
//                if (nextNum > num) {
//                    sum -= num;
//                    continue;
//                }
//            }
//
//            sum += num;
//        }
//
//        return sum;


        int ans = 0 , prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = map.get(s.charAt(i));

            if (cur >= prev) {
                ans += cur;
            } else
                ans -= cur;

            prev = cur;
        }
        return ans;

    }

    public static void main(String[] args) {
        String str = "MCMXCIV";

        romanToInteger romanToInteger = new romanToInteger();
        System.out.println(romanToInteger.romanToInt(str));

    }
}
