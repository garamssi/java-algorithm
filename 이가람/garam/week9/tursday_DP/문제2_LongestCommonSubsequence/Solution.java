package garam.week9.tursday_DP.문제2_LongestCommonSubsequence;

/**
 * https://leetcode.com/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * https://www.youtube.com/watch?v=16G6jjbMhjo
 *
 *
 *
 */
public class Solution {
    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence("abcde", "ace"));

    }

    public static int longestCommonSubsequence(String text1, String text2) {
        // 입력 문자열의 길이
        int length1 = text1.length();
        int length2 = text2.length();

        // 모든 부분 문제에 대해 가장 긴 공통 부분 수열의 길이를 저장할 2차원 배열 생성
        // 모두 0으로 초기화
        int[][] dp = new int[length1 + 1][length2 + 1];

        // dp 배열을 아래에서 위로 구성
        for (int i = 1; i <= length1; ++i) {
            for (int j = 1; j <= length2; ++j) {
                // 문자가 일치하면 대각선 값에 1을 더함
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 문자가 일치하지 않으면, 왼쪽(dp[i][j-1]) 또는 위(dp[i-1][j])의 최대값을 취함
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 우측 하단 셀에 text1과 text2의 가장 긴 공통 부분 수열의 길이가 저장됨
        return dp[length1][length2];
    }


}
