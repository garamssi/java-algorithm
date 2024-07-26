import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] space = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = new Main().solution(n, m, space);

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
    /*
    dp[x][y][0]: ↙ 방향으로 (x,y) 에 도착했을 때의 최소 비용
    dp[x][y][1]: ↓ 방향으로 (x,y) 에 도착했을 때의 최소 비용
    dp[x][y][2]: ↘ 방향으로 (x,y) 에 도착했을 때의 최소 비용

    dp[x][y][0] = Math.min(dp[x - 1][y - 1][1], dp[x - 1][y - 1][2]) + space[x][y];
    dp[x][y][1] = Math.min(dp[x - 1][y][0], dp[x - 1][y][2]) + space[x][y];
    dp[x][y][2] = Math.min(dp[x - 1][y + 1][0], dp[x - 1][y + 1][1]) + space[x][y];
     */

    private int solution(int n, int m, int[][] space) {
        int[][][] dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Integer.MAX_VALUE;
                dp[i][j][2] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            dp[0][i][0] = space[0][i];
            dp[0][i][1] = space[0][i];
            dp[0][i][2] = space[0][i];
        }

        for (int x = 1; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (y == 0) {
                    dp[x][y][1] = dp[x - 1][y][2] + space[x][y];
                    dp[x][y][2] = Math.min(dp[x - 1][y + 1][0], dp[x - 1][y + 1][1]) + space[x][y];
                } else if (y == m - 1) {
                    dp[x][y][1] = dp[x - 1][y][0] + space[x][y];
                    dp[x][y][0] = Math.min(dp[x - 1][y - 1][1], dp[x - 1][y - 1][2]) + space[x][y];
                } else {
                    dp[x][y][0] = Math.min(dp[x - 1][y - 1][1], dp[x - 1][y - 1][2]) + space[x][y];
                    dp[x][y][1] = Math.min(dp[x - 1][y][0], dp[x - 1][y][2]) + space[x][y];
                    dp[x][y][2] = Math.min(dp[x - 1][y + 1][0], dp[x - 1][y + 1][1]) + space[x][y];
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                minCost = Math.min(minCost, dp[n - 1][i][j]);
            }
        }
        return minCost;
    }
}