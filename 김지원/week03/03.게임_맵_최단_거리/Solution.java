import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int row = maps.length;
        int column = maps[0].length;
        int[][] visited = new int[row][column];

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == row - 1 && cur.y == column - 1) {
                return visited[row - 1][column - 1];
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < column // 맵 안에 있고
                        && maps[nextX][nextY] != 0 // 벽이 아니고
                        && visited[nextX][nextY] == 0) { // 방문한적이 없으면
                    visited[nextX][nextY] = visited[cur.x][cur.y] + 1;
                    q.offer(new Point(nextX, nextY));
                }
            }
        }

        return -1;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}