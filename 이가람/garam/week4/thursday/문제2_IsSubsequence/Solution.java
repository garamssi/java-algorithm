package garam.week4.thursday.문제2_IsSubsequence;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {

        if (t.length() < s.length()) {
            return false;
        }

        if (s.isEmpty() || s.isEmpty() && t.isEmpty() ) {
            return true;
        }

        List<Character> list = new ArrayList<>();

        int index = 0;
        int sLength = s.length();
        for (int i = 0; i < t.length(); i++) {

            if ( sLength == index) {
                break;
            }

            if (s.charAt(index) == t.charAt(i)) {
                list.add(s.charAt(index));
                index++;
            }


        }

        return list.size() == s.length();
    }
}
