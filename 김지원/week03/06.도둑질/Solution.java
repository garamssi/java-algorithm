/**
 * dp[i] = max(dp[i-2] + money[i], dp[i-1])
 * 도둑이 i번째 집에 도달 했을 때 훔칠 수 있는 최대 금액
 *
 *
 * 첫번째 집을 훔칠지(dp[0][i]) 안 훔칠지(dp[1][i]) 고려 해야함.
 *
 */
class Solution {
    public int solution(int[] money) {
        // dp[0][i] 첫번째 집을 훔치는 경우
        // dp[1][i] 첫번째 집을 훔치지 않는 경우
        int[][] dp = new int[2][money.length];

        dp[0][0] = money[0];
        dp[0][1] = money[0];

        dp[1][1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + money[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + money[i]);
        }

        return Math.max(dp[0][money.length - 2], dp[1][money.length - 1]);
    }
}