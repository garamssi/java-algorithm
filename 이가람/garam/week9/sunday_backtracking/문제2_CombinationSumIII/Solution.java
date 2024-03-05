package garam.week9.sunday_backtracking.문제2_CombinationSumIII;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-iii/?envType=study-plan-v2&envId=leetcode-75
 * 다음 조건이 충족되는 유효한 k숫자 조합을 모두 찾습니다. n
 *
 * 1까지의 숫자만 9사용됩니다.
 * 각 번호는 최대 한 번만 사용됩니다 .
 * 가능한 모든 유효한 조합의 목록을 반환합니다 . 목록에는 동일한 조합이 두 번 포함되어서는 안 되며, 조합은 어떤 순서로든 반환될 수 있습니다.
 */
public class Solution {
	public static void main(String[] args) {

		combinationSum(3, 9);
	}

	public static List<List<Integer>> combinationSum(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		combination(ans, new ArrayList<Integer>(), k, 1, n);
		return ans;
	}

	private static void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
		if (comb.size() == k && n == 0) {
			List<Integer> li = new ArrayList<>(comb);
			ans.add(li);
			return;
		}
		for (int i = start; i <= 9; i++) {
			comb.add(i);
			combination(ans, comb, k, i+1, n-i);
			comb.remove(comb.size() - 1);
		}
	}
}
