import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] buildings = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int result = new Main().solution(n, buildings);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    private int solution(int n, int[] buildingHeights) {
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            maxCount = Math.max(calculate(i, n, buildingHeights), maxCount);
        }

        return maxCount;
    }

    private int calculate(int cur, int n, int[] buildings) {
        // right
        double maxSlope = 0;
        int visible = 0;
        for (int i = cur + 1; i < n; i++) {
            double slope = (buildings[i] - buildings[cur]) / (double) (i - cur);
            if (i == cur + 1 || slope > maxSlope) {
                visible++;
                maxSlope = slope;
            }
        }

        // left
        for (int i = cur - 1; i >= 0; i--) {
            double slope = (buildings[i] - buildings[cur]) / (double) (cur - i);
            if (i == cur - 1 || slope > maxSlope) {
                visible++;
                maxSlope = slope;
            }
        }

        return visible;
    }
}