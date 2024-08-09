import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] front = new int[n];
        for (int i = 0; i < n; i++) {
            front[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new Main().solution(n, front);
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private int[] solution(int n, int[] front) {
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (result[j] != 0) {
                    continue;
                }
                if (cnt == front[i]) {
                    result[j] = i + 1;
                    break;
                } else {
                    cnt++;
                }
            }
        }
        return result;
    }
}
