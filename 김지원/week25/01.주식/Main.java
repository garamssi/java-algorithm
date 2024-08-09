import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] price = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            long maxProfit = new Main().solution(price);
            sb.append(maxProfit).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private long solution(int[] price) {
        long maxProfit = 0;
        int maxPrice = 0;

        for (int i = price.length - 1; i >= 0; i--) {
            if (maxPrice < price[i]) {
                maxPrice = price[i];
            } else {
                maxProfit += maxPrice - price[i];
            }
        }
        return maxProfit;
    }
}
