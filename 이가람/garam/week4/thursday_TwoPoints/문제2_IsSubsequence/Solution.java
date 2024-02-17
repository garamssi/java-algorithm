package garam.week4.thursday_TwoPoints.문제2_IsSubsequence;

import java.util.*;

/**
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * s문자가 t에 포함되어 있는지? 단, s 순서는 바뀌면 안됨
 *
 */

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

        // 포함 개수 카운트용
        int index = 0;
        int sLength = s.length();

        for (int i = 0; i < t.length(); i++) {

            if ( sLength == index) {
                break;
            }

            if (s.charAt(index) == t.charAt(i)) {
                index++;
            }

        }

        return index == sLength;
    }
}
