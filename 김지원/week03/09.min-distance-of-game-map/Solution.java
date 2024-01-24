import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    Queue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        pq.add(new Position(0, 0, 1));

        int[][] dist = new int[maps.length][maps[0].length];

        while (!pq.isEmpty()) {
            Position cur = pq.poll();

            if (dist[cur.y][cur.x] == 0) {
                dist[cur.y][cur.x] = cur.distance;

                for (int i = 0; i < 4; i++) {
                    int nextY = cur.y + dy[i];
                    int nextX = cur.x + dx[i];
                    boolean movable = isMovable(nextY, nextX, maps);
                    if (movable) {
                        maps[nextY][nextX] = 0;
                        // 현재 위치와 거리+1을 우선순위 큐에 삽입
                        pq.add(new Position(nextY, nextX, cur.distance + 1));
                    }
                }
            }
        }

        int rs = dist[maps.length - 1][maps[0].length - 1];
        return rs != 0 ? rs : -1;
    }

    public boolean isMovable(int y, int x, int[][] maps) {
        return y >= 0 &&
                y < maps.length &&
                x >= 0 &&
                x < maps[0].length &&
                maps[y][x] != 0;
    }

    static class Position {
        final int y;
        final int x;
        final int distance;

        public Position(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}
