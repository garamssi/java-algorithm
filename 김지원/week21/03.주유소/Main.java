import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main t = new Main();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i]= Integer.parseInt(st.nextToken());
        }

        long result = t.solution(n, dist, cost);

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private long solution(int n, int[] dist, int[] cost) {
        long minCost = cost[0];
        long totalCost = 0;

        for (int i = 0; i < n - 1; i++) {
            if (minCost > cost[i]) {
                minCost = cost[i];
            }
            totalCost += minCost * dist[i];
        }

        return totalCost;
    }
}