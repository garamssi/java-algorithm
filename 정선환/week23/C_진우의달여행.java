package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17484
 * 진우의 달 여행(small)
 */
public class C_진우의달여행 {

    static int n, m;
    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = bf.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        int[][] maps = new int[n][m];

        // 지도 세팅
        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            for(int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 좌표
        for (int i = 0; i < m; i++) {
            backtrack(maps, 0, i, -1, 0);
        }

        System.out.println(minValue);
    }

    private static void backtrack(int[][] maps, int x, int y, int previousDirection, int sum) {
        sum += maps[x][y];
        // 달 도착
        if(x == n - 1) {
            minValue = Math.min(minValue, sum);
            return ;
        }


        for (int i = 0; i < 3; i++) {
            if (i == previousDirection) {
                continue;
            }

            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                backtrack(maps, nextX, nextY, i, sum);
            }
        }

    }
}
