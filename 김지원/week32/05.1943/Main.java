import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < 3; t++) {
            int n = Integer.parseInt(br.readLine());
            List<Coin> coins = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int value = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                coins.add(new Coin(value, cnt));
            }
            int result = new Main().solution(n, coins);
            answer.append(result).append("\n");
        }

        bw.write(answer.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public int solution(int n, List<Coin> coins) {
        int sum = 0;
        for (Coin coin : coins) {
            sum += coin.value * coin.cnt;
        }

        // 합이 홀수이면 동전을 나눌 수 없다.
        if (sum % 2 == 1) {
            return 0;
        }

        sum /= 2;

        // dp[i][j] = i번째 까지의 동전을 사용하여 금액 j를 만들 수 있는지 여부
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // 동전을 사용하지 않았을 때
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            Coin cur = coins.get(i - 1);
            for (int j = 0; j <= sum; j++) {
                if (dp[i - 1][j]) {
                    // i번째 동전 0 ~ k개로 만들 수 있는 금액 찾기 
                    for (int k = 0; k <= cur.cnt; k++) {
                        int amount = j + cur.value * k;
                        if (amount <= sum) {
                            dp[i][amount] = true;
                        }
                    }
                }
            }
        }

        return dp[n][sum] ? 1 : 0;
    }

    public static class Coin {
        int value;
        int cnt;

        public Coin(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }
}