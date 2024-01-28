package week4;

/**
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * 392. Is Subsequence
 */
public class E_IsSubsequence {
    public static void main(String[] args) {
//        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("aec", "abcde"));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length())
            if (s.charAt(i) == t.charAt(j++))
                i++;

        return i == s.length();
    }
}
