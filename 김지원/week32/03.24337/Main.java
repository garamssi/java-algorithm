import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String result = new Main().solution(n, a, b);

        bw.write(result);
        br.close();
        bw.flush();
        bw.close();
    }

    private String solution(int n, int a, int b) {
        int maxHeight = Math.max(a, b); // 건물 최고 높이

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < a; i++) {
            q.add(i);
        }
        q.add(maxHeight);
        for (int i = b - 1; i > 0; i--) {
            q.add(i);
        }

        if (q.size() > n) {
            return "-1";
        }

        // 건물 갯수 맞추기
        // 9 1 5 -> 5 4 3 2 1
        // 5 (1 1 1 1) 4 3 2 1
        int first = q.pollFirst();
        int qSize = q.size();
        for (int i = 1; i <= n - qSize - 1; i++) {
            q.addFirst(1);
        }
        q.addFirst(first);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.pollFirst()).append(" ");
        }
        return sb.toString();
    }
}