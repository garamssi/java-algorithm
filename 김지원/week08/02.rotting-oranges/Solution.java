class Solution {
    int[] dx = { 0, 0, 1, -1};
    int[] dy = { 1, -1, 0, 0};

    int[][] days;

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        days = new int[n][m];

        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                        grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    days[nx][ny] = days[cur.x][cur.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }

        int maxDays = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                maxDays = Math.max(maxDays, days[i][j]);
            }
        }

        return maxDays;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}