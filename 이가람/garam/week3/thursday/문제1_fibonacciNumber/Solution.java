package garam.week3.thursday.문제1_fibonacciNumber;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fibonacci-number/description/
public class Solution {

	public static final Map<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		System.out.println(fibonacciNumber(2));
		System.out.println(fibonacciNumber(3));
		System.out.println(fibonacciNumber(4));
		System.out.println(map);
	}

	public static int fibonacciNumber(int n){
		return dfs(n);
	}

	public static int dfs(int n) {
		if ( n <= 1 ) {
			return n;
		}

		if ( map.containsKey(n) ) {
			return map.get(n);
		}

		int result = dfs(n - 1) + dfs(n - 2);
		map.putIfAbsent(n, result);

		return result;

	}
}
