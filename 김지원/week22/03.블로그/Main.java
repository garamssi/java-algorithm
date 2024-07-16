import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] visits = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            visits[i] = Integer.parseInt(st.nextToken());
        }

        String result = new Main().solution(n, x, visits);

        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }

    private String solution(int n, int x, int[] visits) {
        int left = 0;
        int right = x - 1;
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += visits[i];
        }
        int maxSum = sum;
        int maxSumCount = 1;

        while (right < n - 1) {
            sum -= visits[left++];
            sum += visits[++right];

            if (sum > maxSum) {
                maxSum = sum;
                maxSumCount = 1;
            } else if (sum == maxSum) {
                maxSumCount++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (maxSum == 0) {
            sb.append("SAD");
        } else {
            sb.append(maxSum)
                    .append("\n")
                    .append(maxSumCount)
                    .append("\n");

        }

        return sb.toString();
    }
}