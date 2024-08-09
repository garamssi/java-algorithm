import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int result = new Main().solution(n, br);
        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    private int solution(int n, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Queue<Integer> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (!pq.isEmpty() && pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        
        if (!pq.isEmpty()) {
            return pq.poll();
        }
        return 0;
    }
}
