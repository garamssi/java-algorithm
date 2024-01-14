class Solution {

    public int[] dx = { 0, 0, 1, -1 };
    public int[] dy = { 1, -1, 0, 0 };

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j, row, column);
                }
            }
        }

        return cnt;
    }

    private void dfs(char[][] grid, int x, int y, int row, int column) {
        grid[x][y] = '0';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= row || ny < 0 || ny >= column || grid[nx][ny] == '0') {
                continue;
            }

            dfs(grid, nx, ny, row, column);
        }
    }
}