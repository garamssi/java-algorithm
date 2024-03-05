package garam.week7.thursday_암시적DFS.문제1_KeysAndRooms;

import java.util.List;

/**
 * https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
 *
 */
public class Solution {

    public static boolean[] visited;
    public static void main(String[] args) {

    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        visited = new boolean[rooms.size()];

        dfs(rooms, 0);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int v) {
        visited[v] = true;
        for (Integer nextVertex : rooms.get(v)) {
            if (!visited[nextVertex]) {
                dfs(rooms, nextVertex);
            }
        }
    }
}
