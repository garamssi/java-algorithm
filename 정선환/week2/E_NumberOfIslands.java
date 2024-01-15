package week2;

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
        char[][] graph = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        numIslands(graph);
    }

    public static int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; i++) {
                if(grid[i][j] == '1' && visited[i][j] == false) {

                }
            }
        }
        return 0;
    }

}
