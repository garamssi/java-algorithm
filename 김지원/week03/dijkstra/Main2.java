import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    private static final int INF = (int) 1e9;

    public static void main(String[] args) {
        int n = 6;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Node(2, 1));
        graph.get(0).add(new Node(1, 2));

        graph.get(1).add(new Node(4, 7));

        graph.get(2).add(new Node(3, 2));
        graph.get(2).add(new Node(5, 20));

        graph.get(3).add(new Node(4, 1));
        graph.get(3).add(new Node(5, 3));

        int[] dijkstra = new Solution().dijkstra(graph, 0, n);
        System.out.println(Arrays.toString(dijkstra));
    }

    public int[] dijkstra(List<List<Node>> graph, int start, int n) {
        int[] distance = new int[n];
        Arrays.fill(distance, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.index] != INF) {
                continue;
            }

            distance[now.index] = now.distance;
            for (Node next : graph.get(now.index)) {
                int cost = now.distance + next.distance;
                pq.offer(new Node(next.index, cost));
            }
        }
        return distance;
    }

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }
}