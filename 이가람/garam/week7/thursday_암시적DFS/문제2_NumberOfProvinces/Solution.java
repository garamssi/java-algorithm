package garam.week7.thursday_암시적DFS.문제2_NumberOfProvinces;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75
 *
 */
public class Solution {

    public static int totalCnt = 0;

    public static void main(String[] args) {

//        [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        /**
         * 1 0 0 1
         * 0 1 1 0
         * 0 1 1 1
         * 1 0 1 1
         */
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i + 1).add(j + 1);
                }
            }
        }

        System.out.println(adj);

        int visit[] = new int[n + 1];

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0) {
                dfs(i, adj, visit);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int start, List<List<Integer>> adj, int[] visit) {
        visit[start] = 1;

        for (int node : adj.get(start)) {
            if (visit[node] == 0) {
                dfs(node, adj, visit);
            }
        }
    }

}
