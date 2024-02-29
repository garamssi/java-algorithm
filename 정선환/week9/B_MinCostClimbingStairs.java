package week9;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75
 * 746. Min Cost Climbing Stairs
 */
public class B_MinCostClimbingStairs {
    public static void main(String[] args) {
//        int[] cost = {10,15,20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
//        int[] cost = {0,2,2,1};
        int i = minCostClimbingStairs(cost);
        System.out.println(i);
    }

    public static int minCostClimbingStairs(int[] cost) {
        return dp(cost, cost.length);
    }

    static Map<Integer, Integer> memo = new HashMap<>();
    public static int dp(int[] cost, int n) {
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        if(n == 0 || n == 1) {
            return 0;
        }

        memo.put(n, Math.min(dp(cost, n - 1) + cost[n - 1], dp(cost, n - 2) + cost[n - 2]));
        return memo.get(n);
    }
}
