import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        char[] table = input.toCharArray();
        int result = new Main().solution(n, k, table);

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private int solution(int n, int k, char[] table) {
        int numPeopleAte = 0;

        for (int i = 0; i < n; i++) {
            if (table[i] == 'P') {
                // 햄버거를 왼쪽 가장 멀리 떨어진 것부터 먹는다.
                int from = Math.max(0, i - k);
                int to = Math.min(n - 1, i + k);
                for (int ptr = from; ptr <= to; ptr++) {
                    if (table[ptr] == 'H') {
                        table[ptr] = 'E';
                        numPeopleAte++;
                        break;
                    }
                }
            }
        }
        return numPeopleAte;
    }
}