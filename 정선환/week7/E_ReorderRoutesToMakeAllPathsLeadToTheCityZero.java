package week7;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 */
public class E_ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static void main(String[] args) {
        int[][] connections = {
                {0,1},
                {1,3},
                {2,3},
                {4,0},
                {4,5}
        };

        System.out.println(minReorder(6, connections));
    }

    public static int minReorder(int n, int[][] connections) {
        if (connections == null || connections.length == 0) {
            return 0;
        }

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(new int[]{to, 1});
            graph.get(to).add(new int[]{from, 0});
        }

        boolean[] visited = new boolean[n];
        int[] count = new int[]{0};

        dfs(0, graph, visited, count);

        return count[0];
    }

    private static void dfs(int city, List<List<int[]>> graph, boolean[] visited, int[] count) {
        visited[city] = true;
        for (int[] neighbor : graph.get(city)) {
            int nextCity = neighbor[0];
            boolean forward = neighbor[1] == 1;
            if (!visited[nextCity]) {
                if (forward) {
                    count[0]++;
                }
                dfs(nextCity, graph, visited, count);
            }
        }
    }
}
