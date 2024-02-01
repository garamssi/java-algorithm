package garam.week5.tuesday.문제3_DetermineIfTwoStringsAreClose;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75
 *
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(closeStrings("abc", "bca"));
//        closeStrings("a", "aa");
        closeStrings("uau", "ssx");
    }

    public static boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < word1.length(); ++i) {
            int i1 = word1.charAt(i) - 'a';
            freq1[i1]++;
        }

        for (int i = 0; i < word2.length(); ++i) {
            int i1 = word2.charAt(i) - 'a';
            freq2[i1]++;
        }

        for (int i = 0; i < 26; ++i) {
            // freq1[i] 0보다 크면서 freq2[i]가 0일 때
            // freq2[i] 0보다 크면서 freq1[i]가 0일 때
            if ((freq1[i] > 0 && freq2[i] == 0) || (freq2[i] > 0 && freq1[i] == 0)) {
                return false;
            }

        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; ++i) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
