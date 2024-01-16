package week3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 게임 맵 최단거리
 */
public class C_GameMapShortestDistance {
    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };

        solution(maps);
    }

    static int m;
    static int n;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int solution(int[][] maps) {
        int answer = 0;

        // 맵 전체 길이
        m = maps.length;
        n = maps[0].length;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(maps[i][j] == 1) {
                    bfs(maps, i, j);
                }
            }
        }
        answer = bfs(maps, 0, 0);

        return answer;
    }

    public static int bfs(int[][] maps, int x, int y) {
        visited[x][y] = true;
        int moveCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        // 목적지
        int finishX = m - 1;
        int finishY = n - 1;

        while(!queue.isEmpty()) {
            int[] currentXY = queue.poll();

            int moveX = 0;
            int moveY = 0;

            for(int i = 0; i < 4; i++) {
                int nextX = currentXY[0] + dx[i];
                int nextY = currentXY[1] + dy[i];

                if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < m &&
                        visited[nextX][nextY] == true &&
                        maps[nextX][nextY] == 1) {

                    // 이동 하면 되는데 가장 가까운 좌표 구하기
                    int shortestSum = Integer.MAX_VALUE;
                    int xySum = (m + n) - (nextX + nextY);
                    if(shortestSum > xySum) {
                        shortestSum = xySum;
                        moveX = nextX;
                        moveY = nextY;
                    }
                }
            }

            visited[moveX][moveY] = true;
            queue.offer(new int[]{moveX, moveY});
            moveCount++;
        }

        return moveCount;
    }
}
