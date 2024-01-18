package week3;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * 최소 비용 계단 등반
 */
public class D_MinCostClimbingStairs {
    public static void main(String[] args) {
//        int[] cost = {
//                10, 15, 20
//        };
        int[] cost = {
                1, 100, 1, 1, 1, 100, 1, 1, 100, 1
        };
        System.out.println(minCostClimbingStairs(cost));
    }

    static int[] costs = null;
    public static int minCostClimbingStairs(int[] array) {
        costs = array;
        return dp(costs.length);
    }

    public static int dp(int n) {
        if(n == 0 || n == 1) {
            return 0;
        }
        int min = Math.min(dp(n - 1) + costs[n - 1], dp(n - 2) + costs[n - 2]);

        return min;
    }

}
