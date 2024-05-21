package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();

        int n = Integer.parseInt(br.readLine());

        String result = t.solution(n);
        System.out.println(result);
    }

    // 1 -> SK
    // 0 -> CY
    public String solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            if (dp[i - 1] == 1 || dp[i - 3] == 1) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }
        }
        return dp[n] == 1 ? "SK" : "CY";
    }
}