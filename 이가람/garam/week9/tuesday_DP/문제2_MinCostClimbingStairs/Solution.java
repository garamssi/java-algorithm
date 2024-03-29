package garam.week9.tuesday_DP.문제2.MinCostClimbingStairs;


import java.util.*;


/***
 * https://leetcode.com/problems/min-cost-climbing-stairs/?envType=study-plan-v2&envId=leetcode-75
 * 개발남노씨 minCostClimbingStairs 문제 참고,
 *
 * 메모이제이션 방식
 */
public class Solution {

    public static void main(String[] args) {

        minCostClimbingStairs(new int[]{});
    }

    public static int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(memo, cost, n);
    }

    public static int dp(int[] memo, int[] cost, int n ){
        if(n == 0 || n == 1){
            return 0;
        }
        else if(memo[n] == -1){
            memo[n] = Math.min(dp(memo, cost, n - 1) + cost[n - 1],  dp(memo, cost, n - 2) + cost[n - 2]);
        }
        return memo[n];
    }

}
