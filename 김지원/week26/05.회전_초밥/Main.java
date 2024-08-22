import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushes = new int[n];
        for (int i = 0; i < n; i++) {
            sushes[i] = Integer.parseInt(br.readLine());
        }

        int result = new Main().solution(n, d, k, c, sushes);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    // 슬라이딩 윈도우
    // k 만큼의 범위안에 먹을 수 있는 최대 가지 수를 구한다.
    private int solution(int n, int d, int k, int c, int[] sushes) {
        int[] eat = new int[d + 1];

        for (int i = 0; i < k; i++) {
            eat[sushes[i]]++;
        }
        int ans = getEatCnt(eat, c);

        int left = 0;
        int right = k - 1;

        while (left < sushes.length) {
            eat[sushes[(left++) % n]]--;
            eat[sushes[++right % n]]++;

            ans = Math.max(ans, getEatCnt(eat, c));
        }

        return ans;
    }

    private int getEatCnt(int[] eat, int c) {
        int cnt = 0;
        for (int i = 0; i < eat.length; i++) {
            if (eat[i] > 0) {
                cnt++;
            }
        }

        if (eat[c] == 0) {
            cnt++;
        }

        return cnt;
    }
}