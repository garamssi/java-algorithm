package garam.week9.tuesday_DP.문제1_N_thTribonacciNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=leetcode-75
 * 트리보나치
 *
 * 탑-다운 방식,
 */
public class Solution {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }

    public static int tribonacci(int n) {
        return dfs(n);
    }

    private static int dfs(int n) {
        if ( n == 0 ) {
            return 0;
        }

        if ( n == 1 || n == 2) {
            return 1;
        }

        if ( n == 3 ) {
            return 2;
        }

        if (!memo.containsKey(n)){
            memo.putIfAbsent(n, dfs(n-1) + dfs(n-2) + dfs(n-3));
        }
        return memo.get(n);
    }




}
