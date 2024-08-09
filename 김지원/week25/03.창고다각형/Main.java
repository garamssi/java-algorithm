import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] columns = new int[1001];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int pos = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            columns[pos] = height;
        }
        int result = new Main().solution(columns);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    private int solution(int[] columns) {
        // find max height of column
        int maxColumnPos = 0;
        int maxColumnHeight = 0;
        for (int i = 0; i < columns.length; i++) {
            if (columns[i] > maxColumnHeight) {
                maxColumnPos = i;
                maxColumnHeight = columns[i];
            }
        }

        int area = 0;
        // left
        int curMaxHeight = 0;
        for (int i = 0; i < maxColumnPos + 1; i++) {
            curMaxHeight = Math.max(columns[i], curMaxHeight);
            area += curMaxHeight;
        }

        // right
        curMaxHeight = 0;
        for (int i = columns.length - 1; i > maxColumnPos; i--) {
            curMaxHeight = Math.max(columns[i], curMaxHeight);
            area += curMaxHeight;
        }

        return area;
    }
}