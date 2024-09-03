import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = new Main().solution(start, end);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    /*
    bfs + priorityQueue
     */
    static final int MAX_POS = 100_000;

    private int solution(int start, int end) {
        boolean[] visited = new boolean[MAX_POS + 1];
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.add(new Position(start, 0));
        visited[start] = true;

        while (!pq.isEmpty()) {
            Position cur = pq.poll();
            visited[cur.x] = true;

            if (cur.x == end) {
                return cur.time;
            }

            int nx = 2 * cur.x;
            if (nx <= MAX_POS && !visited[nx]) {
                pq.offer(new Position(nx, cur.time));
            }

            nx = cur.x + 1;
            if (nx <= MAX_POS && !visited[nx]) {
                pq.offer(new Position(nx, cur.time + 1));
            }

            nx = cur.x - 1;
            if (nx >= 0 && !visited[nx]) {
                pq.offer(new Position(nx, cur.time + 1));
            }
        }

        return -1;
    }

    static class Position implements Comparable<Position> {
        int x;
        int time;

        public Position(int x, int time) {
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Position o) {
            return this.time - o.time;
        }
    }
}