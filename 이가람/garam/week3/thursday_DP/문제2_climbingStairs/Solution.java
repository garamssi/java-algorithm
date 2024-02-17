package garam.week3.thursday_DP.문제2_climbingStairs;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/climbing-stairs/
public class Solution {

	public static final Map<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		climbStairs(3);
	}

	public static int climbStairs(int n){
		if ( n <= 2 ) {
			return n;
		}

		if ( map.containsKey(n) ) {
			return map.get(n);
		}

		int result = climbStairs(n - 1) + climbStairs(n - 2);
		map.putIfAbsent(n, result);

		return result;
	}
}
