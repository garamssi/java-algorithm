import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] nums = new int[t];
        for (int i = 0; i < t; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        String result = new Main().solution(t, nums);

        bw.write(result);
        br.close();
        bw.flush();
        bw.close();
    }

    /*
    dp[a][b] => a 를 만드는 경우의 수 중 1로 끝나는 경우의 수
    dp[n][1] = dp[n-1][1]
    dp[n][2] = dp[n-2][1] + dp[n-2][2]
    dp[n][3] = dp[n-3][1] + dp[n-3][2] + dp[n-3][3]
     */
    private String solution(int t, int[] nums) {
        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int num = nums[i];
            int result = dp[num][1] + dp[num][2] + dp[num][3];
            sb.append(result).append("\n");
        }
        return sb.toString();
    }
}