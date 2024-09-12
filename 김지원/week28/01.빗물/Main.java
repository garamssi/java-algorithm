import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] map = new int[w];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < w; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int result = new Main().solution(h, w, map);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    private int solution(int h, int w, int[] map) {
        int hh = 0; // 가장 높은 기둥의 높이
        int hi = 0; // 가장 높은 기둥의 index

        // 가장 높은 기둥의 높이, idx 를 찾는다.
        for (int i = 0; i < w; i++) {
            if (map[i] > hh) {
                hi = i;
                hh = map[i];
            }
        }

        // hi 기준으로 나눈다.
        // 왼쪽: 0 ~ hi - 1
        int max = 0;
        int sum = 0;
        for (int i = 0; i < hi; i++) {
            max = Math.max(max, map[i]);
            sum += max - map[i];
        }

        // 오른쪽: hi + 1 ~ w - 1
        max = 0;
        for (int i = w - 1; i > hi; i--) {
            max = Math.max(max, map[i]);
            sum += max - map[i];
        }

        return sum;
    }
}