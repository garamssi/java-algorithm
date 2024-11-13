package week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1238
 * 파티
 */
public class E_파티 {

    static int N;
    static int M;
    static int X;

    static List<List<Node>> maps = new ArrayList<>();
    static List<List<Node>> reverseMaps = new ArrayList<>();

    static class Node implements Comparable<Node>{
        int nodeId;
        int cost;

        public Node(int nodeId, int cost) {
            this.nodeId = nodeId;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        X = Integer.parseInt(st.nextToken());
//
//        for (int i = 1; i <= N + 1; i++) {
//            maps.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(bf.readLine(), " ");
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//            int cost = Integer.parseInt(st.nextToken());
//
//            maps.get(start).add(new Node(end, cost));
//        }
//
//        int maxCost = 0;
//        for (int i = 1; i < N + 1; i++) {
//            int minCost = dijkstra(i, X);
//            maxCost = Math.max(maxCost, minCost);
//        }
//
//        System.out.println(maxCost);
//
//    }
//
//    public static int dijkstra(int start, int end) {
//        int minCost = 0;
//        Map<Integer, Integer> costs = new HashMap<>();
//        Queue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
//
//        priorityQueue.offer(new Node(start, 0));
//
//        while(!priorityQueue.isEmpty()) {
//            Node currNode = priorityQueue.poll();
//
//            if(currNode.nodeId == end) {
//                minCost = Math.min(minCost, currNode.cost);
//                continue;
//            }
//
//            if(!costs.containsKey(currNode.nodeId)) {
//                costs.put(currNode.nodeId, currNode.cost);
//
//                for (Node nextNode : maps.get(currNode.nodeId)) {
//                    int nextCost = currNode.cost + nextNode.cost;
//                    priorityQueue.offer(new Node(nextNode.nodeId, nextCost));
//                }
//            }
//        }
//
//        return costs.get(end);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // Initialize adjacency lists
        for (int i = 0; i <= N; i++) {
            maps.add(new ArrayList<>());
            reverseMaps.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            maps.get(start).add(new Node(end, cost));
            reverseMaps.get(end).add(new Node(start, cost));
        }

        int[] goCost = dijkstra(maps, X);
        int[] backCost = dijkstra(reverseMaps, X);

        int maxCost = 0;
        for (int i = 1; i <= N; i++) {
            maxCost = Math.max(maxCost, goCost[i] + backCost[i]);
        }

        System.out.println(maxCost);
    }

    public static int[] dijkstra(List<List<Node>> graph, int start) {
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node currNode = priorityQueue.poll();
            int currId = currNode.nodeId;
            int currCost = currNode.cost;

            if (currCost > costs[currId]) {
                continue;
            }

            for (Node nextNode : graph.get(currId)) {
                int nextCost = currCost + nextNode.cost;
                if (nextCost < costs[nextNode.nodeId]) {
                    costs[nextNode.nodeId] = nextCost;
                    priorityQueue.offer(new Node(nextNode.nodeId, nextCost));
                }
            }
        }

        return costs;
    }
}
