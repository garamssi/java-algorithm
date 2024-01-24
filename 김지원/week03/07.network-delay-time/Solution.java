import java.util.*;

class Solution {
    
    static final int INF = (int) 1e9;
    
    int[] distance;

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        for (int[] time : times) {
            graph.get(time[0]).add(new Node(time[1], time[2]));
        }

        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));

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

        int maxValue = -1;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == INF) {
                return -1;
            }
            maxValue = Math.max(maxValue, distance[i]);
        }
        
        return maxValue;
    }

    static class Node implements Comparable<Node> {
        final int index;
        final int distance;

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