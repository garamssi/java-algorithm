// i번째 계단에 도달했을 때의 비용 : f(i) = min(f(i - 1), f(n-2)) + cost[i];
// 계단이 n개 있을때, 정상에 도달했을 때의 비용 : min(dp[n - 1], dp[n - 2]);
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int topIndex = cost.length;

        if (topIndex == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[topIndex];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}