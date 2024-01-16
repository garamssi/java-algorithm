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

        System.out.println(solution(maps));
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

        answer = bfs(maps, 0, 0);

        return answer;
    }

    public static int bfs(int[][] maps, int x, int y) {
        int moveCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] currentXY = queue.poll();

            // 목적지 도달
            if(currentXY[0] == m - 1 && currentXY[1] == n -1) {
                moveCount++;
                break;
            }

            int moveX = 0;
            int moveY = 0;
            int shortestSum = Integer.MAX_VALUE;

            for (int i = 0; i < 4; i++) {
                if(currentXY[0] == m -1 && currentXY[1] == n -1) {
                    break;
                }
                int nextX = currentXY[0] + dx[i];
                int nextY = currentXY[1] + dy[i];

                // 방문하면 안되는 조건
                // 1. m,n을 넘어서면 안됨
                // 2. 방문했던 좌표는 제외
                // 3. 벽인 좌표 제외
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < m &&
                        !visited[nextX][nextY] &&
                        maps[nextX][nextY] == 1) {

                    // 가장 가까운 길 구하기
                    int xySum = (m + n) - (nextX + nextY);
                    if (shortestSum > xySum) {
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
