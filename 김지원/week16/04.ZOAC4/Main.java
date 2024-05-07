import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = new Main().solution(h, w, n, m);
        System.out.println(result);
    }

    public int solution(int h, int w, int n, int m) {
        int count = 0;
        for (int i = 0; i < h; i += (1 + n)) {
            for (int j = 0; j < w; j += (1 + m)) {
                count++;
            }
        }
        return count;
    }

    public int solution2(int h, int w, int n, int m) {
        h = (int) Math.ceil((double) h / (n + 1));
        w = (int) Math.ceil((double) w / (m + 1));
        return h * w;
    }
}