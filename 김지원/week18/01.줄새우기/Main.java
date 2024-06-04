import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        int[] heights = new int[20];

        for (int i = 0; i < n; i++) {
            // input
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            for (int j = 0; j < 20; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }
            result[i] = t.solution(heights);
        }

        // calculate
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i + 1).append(" ").append(result[i]).append("\n");
        }

        // output
        System.out.println(sb);
    }

    public int solution(int[] heights) {
        int cnt = 0;
        int pickIndex = 0;
        while ((pickIndex = pick(heights)) > 0) {
            for (int i = pickIndex; i > 0; i--) {
                if (heights[pickIndex] < heights[pickIndex - 1]) {
                    swap(heights, pickIndex, pickIndex - 1);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void swap(int[] heights, int i, int j) {
        int temp = heights[i];
        heights[i] = heights[j];
        heights[j] = temp;
    }

    private int pick(int[] heights) {
        for (int i = 1; i < heights.length; i++) {
            if (heights[i - 1] > heights[i]) {
                return i;
            }
        }
        return 0;
    }
}