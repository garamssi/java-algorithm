import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main t = new Main();

        int n = Integer.parseInt(br.readLine());


        int result = t.solution(n);

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public int solution(int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() >= 2) {
            queue.poll();
            Integer num = queue.poll();
            queue.offer(num);
        }

        if (!queue.isEmpty()) {
            return queue.poll();
        }
        
        return -1;
    }
}