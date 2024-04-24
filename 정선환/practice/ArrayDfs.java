package practice;

import java.util.ArrayList;
import java.util.List;

public class ArrayDfs {

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

        List<Integer> answer = new ArrayList<>();
        dfs(arrays, 0, 0, answer);
        System.out.println(answer);
    }

    static int n, m;
    static boolean[][] visited;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static List<Integer> dfs(int[][] arrays, int x, int y, List<Integer> answer) {
        visited[x][y] = true;

        int num = arrays[x][y];
        answer.add(num);

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                    && visited[nextX][nextY] == false) {
                dfs(arrays, nextX, nextY, answer);
            }
        }

        return answer;
    }

}
