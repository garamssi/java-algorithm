import java.util.*;

public class Main {

    public static final int INF = (int) 1e9;

    public static List<List<Node>> graph;
    public static int[] distance;
    public static int n, m, start;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        start = scanner.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int dis = scanner.nextInt();

            graph.get(from).add(new Node(to, dis));
        }
        Main t = new Main();
        t.dijkstra(start);

        for (int i = 1; i <= n; i++) {
            if (distance[i] == INF) {
                System.out.print("INF ");
            } else {
                System.out.print(distance[i] + " ");
            }
        }
    }

    private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.getIndex()] < now.getDistance()) {
                continue;
            }

            for (Node next : graph.get(now.getIndex())) {
                int cost = distance[now.getIndex()] + next.getDistance(); // start -> now -> next

                if (cost < distance[next.getIndex()]) {
                    distance[next.getIndex()] = cost;
                    pq.offer(new Node(next.getIndex(), cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}