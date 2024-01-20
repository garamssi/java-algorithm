import java.util.*;

class Solution {
    private static final int INF = (int) 1e9;

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Node>> graph = new ArrayList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            graph.get(time[0]).add(new Node(time[1], time[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));
        distance[k] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.index] < now.distance) {
                continue;
            }

            for (Node next : graph.get(now.index)) {
                int cost = distance[now.index] + next.distance;
                if (distance[next.index] > cost) {
                    distance[next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }
        int cnt = 0;
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] != INF) {
                cnt++;
                maxValue = Math.max(maxValue, distance[i]);
            }
        }
        return cnt == n ? maxValue : -1;
    }

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}