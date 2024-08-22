import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] loads = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            loads[i][0] = Integer.parseInt(st.nextToken());
            loads[i][1] = Integer.parseInt(st.nextToken());
            loads[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = new Main().solution(n, d, loads);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    // dp[i] = i에 도착 했을때의 최단거리
    // dp[i] = min(dp[i], dp[start] + 지름길의 길이)
    private int solution(int n, int d, int[][] loads) {
        int[] dp = new int[d + 1];

        for (int i = 0; i <= d; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= d; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            for (int j = 0; j < n; j++) {
                if (loads[j][1] == i) {
                    dp[i] = Math.min(dp[i], dp[loads[j][0]] + loads[j][2]);
                }
            }
        }
        return dp[d];
    }
}