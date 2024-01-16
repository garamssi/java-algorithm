package week2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class E_NumberOfIslands {

    static int m;
    static int n;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) {
//        char[][] graph = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };

        char[][] graph = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(graph));

    }

    public static int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int numberOfIsland = 0;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && visited[i][j] == false) {
                    numberOfIsland += bfs(grid, i, j);
                }
            }
        }
        return numberOfIsland;
    }

    public static int bfs(char[][] graph, int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                // 방문하면 안되는 조건
                // 1. m,n 을 넘어서면 안됨
                // 2. 방문했던 좌표는 제외
                // 3. 물인 좌표 제외
                if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if(!visited[nextX][nextY] && graph[nextX][nextY] == '1') {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return 1;
    }
}
