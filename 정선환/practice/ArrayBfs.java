package practice;

import java.util.*;

public class ArrayBfs {

    public static void main(String[] args) {
        int[][] arrays = {
                {1,   2,  3,  4,  5},
                {6,   7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        n = arrays.length;
        m = arrays[0].length;

        visited = new boolean[n][m];
        List<Integer> answer = bfs(arrays, 0, 0);

        System.out.println(answer);
    }

    static int n, m;
    static boolean[][] visited;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static List<Integer> bfs(int[][] arrays, int x, int y) {
        List<Integer> answer = new ArrayList<>();
        Deque<int[]> deque = new LinkedList<>();
        visited[x][y] = true;

        // 해당 좌표 대기열 추가
        int[] xy = new int[]{x, y};
        deque.offer(xy);

        // 덱에 대기열 처리
        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            // 상하좌우 값
            for(int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if((nextX >= 0 && nextX < n && nextY >= 0 && nextY < m)) {
                    if(visited[nextX][nextY] == false) {
                        visited[nextX][nextY] = true;
                        deque.offer(new int[]{nextX, nextY});
                    }
                }
            }

            answer.add(arrays[currentX][currentY]);
        }

        return answer;
    }

}
