class Solution {
    int[][] steps;

    int[] x = { 0, 0, 1, -1 };
    int[] y = { 1, -1, 0, 0 };

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        steps = new int[n][m];

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(entrance[0], entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (!(cur.x == entrance[0] && cur.y == entrance[1]) &&
                    (cur.x == 0 || cur.y == 0 || cur.x == n - 1 || cur.y == m - 1)) {
                return steps[cur.x][cur.y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + x[i];
                int ny = cur.y + y[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == '.') {
                    q.offer(new Point(nx, ny));
                    maze[nx][ny] = '+';
                    steps[nx][ny] = steps[cur.x][cur.y] + 1;
                }
            }
        }
        return -1;
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