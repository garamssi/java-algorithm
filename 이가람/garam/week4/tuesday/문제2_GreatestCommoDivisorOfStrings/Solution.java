package garam.week4.tuesday.문제2_GreatestCommoDivisorOfStrings;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
 *
 *
 */
public class Solution {

    public static void main(String[] args) {
//        System.out.println(gcdOfStrings("ABCABC", "ABC"));
//        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
    }

    public static String gcdOfStrings(String str1, String str2) {

        // 나눌 수 있는 문자인지 아닌지
        // "ABABABABAB" "ABABABABAB"
        // "ABCABCABC" "ABCABCABC"
        if (!(str1 + str2).equals(str2 + str1))
            return "";

        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
