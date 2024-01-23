import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new Node(time[1], time[2]));
        }


        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);


        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIndex = cur.to;
            int curDistance = cur.distance;

            if (dist[curIndex] != INF) {
                continue;
            }

            dist[curIndex] = curDistance;
            for (Node next : graph.get(curIndex)) {
                int alt = curDistance + next.distance;
                pq.add(new Node(next.to, alt));
            }
        }

        int maxDistance = -1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                return -1;
            }
            maxDistance = Math.max(maxDistance, dist[i]);
        }
        return maxDistance;
    }

    static class Node implements Comparable<Node> {
        int to;
        int distance;

        public Node(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}