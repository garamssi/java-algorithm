package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 9;
        int[][] flights = {
                {0, 4, 20}, {4, 5, 20}, {5, 6, 20}, {6, 1, 40}, {1, 2, 200},
                {0, 7, 30}, {7, 8, 30}, {8, 1, 60}, {1, 3, 50}, {3, 2, 50}
        };
        int src = 0, dst = 2, k = 4;
        int rs = solution.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(rs);
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Node(flight[1], flight[2]));
        }


        // 해당 노드의 진행 경로의 수 저장, 방문하지 않은 노드는 -1
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.index == dst) {
                return now.distance;
            }

            visited[now.index] = now.visitedCnt;

            if (now.visitedCnt > k) {
                continue;
            }

            for (Node next : graph.get(now.index)) {
                if (visited[next.index] == -1 || now.visitedCnt < visited[next.index]) {
                    int cost = now.distance + next.distance;
                    pq.offer(new Node(next.index, cost, now.visitedCnt + 1));
                }
            }
        }
        return -1;
    }

    static class Node implements Comparable<Node> {
        final int index;
        final int distance;
        int visitedCnt;

        public Node(int index, int distance, int visitedCnt) {
            this.index = index;
            this.distance = distance;
            this.visitedCnt = visitedCnt;
        }

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