import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int road = Integer.parseInt(st.nextToken());
                if (road == 0 && i != j) {
                    road = INF;
                }
                graph[i][j] = road;
            }
        }

        int[] route = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            route[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        boolean result = new Main().solution(graph, route, n, m);
        bw.write(result ? "YES" : "NO");
        br.close();
        bw.flush();
        bw.close();
    }

    private boolean solution(int[][] graph, int[] route, int n, int m) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        int start = route[0];
        for (int i = 0; i < m; i++) {
            if (graph[start][route[i]] == INF) {
                return false;
            }
            start = route[i];
        }
        return true;
    }
}
