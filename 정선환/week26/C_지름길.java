package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1446
 * 지름길
 */
public class C_지름길 {

    static class Node {
        int nodeId;
        int cost;

        public Node(int nodeId, int cost) {
            this.nodeId = nodeId;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[D + 1];
        for (int i = 0; i < graph.length; i++) {
            Node node = new Node(i + 1, 1);
            graph[i] = new ArrayList<>();
            if(i != D) {
                graph[i].add(node);
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int range = Integer.parseInt(st.nextToken());

            if(end <= D) {
                graph[start].add(new Node(end, range));
            }
        }

        System.out.println(dijkstra(D));

    }

    private static int dijkstra(int end) {
        Map<Integer, Integer> visited = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        priorityQueue.offer(new Node(0, 0));

        while(!priorityQueue.isEmpty()) {
            Node currNode = priorityQueue.poll();

            // 방문이력 없으면,
            if(!visited.containsKey(currNode.nodeId)) {

                // 방문
                visited.put(currNode.nodeId, currNode.cost);

                // 다음 길 찾기
                for (Node nextNode : graph[currNode.nodeId]) {
                    int nextCost = currNode.cost + nextNode.cost;
                    priorityQueue.offer(new Node(nextNode.nodeId, nextCost));
                }

            }
        }

        return visited.get(end);
    }



}
