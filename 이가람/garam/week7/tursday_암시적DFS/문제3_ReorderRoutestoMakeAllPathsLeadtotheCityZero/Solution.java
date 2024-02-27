package garam.week7.tursday_암시적DFS.문제3_ReorderRoutestoMakeAllPathsLeadtotheCityZero;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class Solution {
	public static void main(String[] args) {

		//        [[0,1],[1,3],[2,3],[4,0],[4,5]]
		//        6
		minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}});
	}

	public static int count = 0;

	public static int minReorder(int n, int[][] connections) {
		boolean visit[] = new boolean[n];
		List<List<Integer>> graph = new ArrayList<>();

		for(int i = 0; i < n; i++)
			graph.add(i, new ArrayList<>());

		for(int[] nums : connections) {
			graph.get(nums[0]).add(nums[1]);
			graph.get(nums[1]).add(-nums[0]);
		}
		dfs(graph, visit, 0);
		return count;
	}

	private static void dfs(List<List<Integer>> graph, boolean[] visit, int i) {
		if(!visit[i]) {
			visit[i] = true;
			for(int num : graph.get(i)) {
				int absNum = Math.abs(num);
				if(!visit[absNum]) {
					if(num > 0)
						count++;
					dfs(graph, visit, absNum);
				}
			}
		}
	}

}
