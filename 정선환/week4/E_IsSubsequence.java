package week4;

/**
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * 392. Is Subsequence
 */
public class E_IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("", "abc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }

        int sIndex = 0;
        int tLength = t.length();

        for(int i = 0; i < tLength; i++) {
            if(s.charAt(sIndex) == t.charAt(i)) {
                sIndex ++;
            }

            if(sIndex == s.length()) {
                return true;
            }
        }

        return false;
    }
}
