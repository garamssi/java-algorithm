// dp[i][j]: triangle[i][j]에 도달했을 때의 최대값
// dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j]

class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
            }
        }

        int max = -1;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[len - 1][i]);
        }
        return max;
    }
}