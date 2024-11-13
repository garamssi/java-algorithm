import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = new Main().solution(n, m, x, edges);

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    static final int INF = (int) 1e9;

    private int solution(int n, int m, int x, int[][] edges) {
        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> rGraph = new ArrayList<>(); // edge 를 거꾸로 한 그래프

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            rGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]));
            rGraph.get(edges[i][1]).add(new Node(edges[i][0], edges[i][2]));
        }

        int[] distance = new int[n + 1];
        int[] rDistance = new int[n + 1];

        Arrays.fill(distance, INF);
        Arrays.fill(rDistance, INF);

        dijkstra(graph, distance, x);
        dijkstra(rGraph, rDistance, x);

        int maxTime = 0;
        for (int i = 1; i < n + 1; i++) {
            maxTime = Math.max(maxTime, distance[i] + rDistance[i]);
        }

        return maxTime;
    }

    private void dijkstra(List<List<Node>> graph, int[] distance, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.p] != INF) {
                continue;
            }

            distance[now.p] = now.time;

            for (Node next : graph.get(now.p)) {
                pq.offer(new Node(next.p, now.time + next.time));
            }
        }
    }

    static class Node implements Comparable<Node> {
        int p;
        int time;

        public Node(int p, int time) {
            this.p = p;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}