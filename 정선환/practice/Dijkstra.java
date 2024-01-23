package practice;

import java.util.*;

public class Dijkstra {
    static class Node {
        int nodeId;
        int cost;

        public Node(int nodeId, int cost) {
            this.nodeId = nodeId;
            this.cost = cost;
        }

    }
    public static void main(String[] args) {
//        int[][] graph = {
//                {1, 2, 2},
//                {1, 4, 1},
//                {2, 3, 1},
//                {2, 5, 9},
//                {2, 6, 6},
//                {3, 6, 4},
//                {4, 3, 3},
//                {4, 7, 5},
//                {5, 8, 1},
//                {6, 5, 3},
//                {7, 6, 7},
//                {7, 8, 9}
//        };

        Map<Integer, List<Node>> graph = new HashMap<>();
        graph.put(1, List.of(new Node(2, 2), new Node(1, 4)));
        graph.put(2, List.of(new Node(3, 1), new Node(5, 9), new Node(6, 6)));
        graph.put(3, List.of(new Node(6, 4)));
        graph.put(4, List.of(new Node(3, 3), new Node(7, 5)));
        graph.put(5, List.of(new Node(8, 1)));
        graph.put(6, List.of(new Node(5, 3)));
        graph.put(7, List.of(new Node(6, 7), new Node(8, 9)));
        graph.put(8, new ArrayList<>());

        System.out.println(dijkstra(graph, 1, 8));
    }

    private static int dijkstra(Map<Integer, List<Node>> graph, int start, int end) {
        Map<Integer, Integer> costs = new HashMap<>();
        Queue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        // 시작
        priorityQueue.offer(new Node(start, 0));

        while(!priorityQueue.isEmpty()) {
            Node currNode = priorityQueue.poll();
            if(!costs.containsKey(currNode.nodeId)) {
                costs.put(currNode.nodeId, currNode.cost);

                // 다음 길 찾기
                for (Node nextNode : graph.get(currNode.nodeId)) {
                    int nextCost = currNode.cost + nextNode.cost;
                    priorityQueue.offer(new Node(nextNode.nodeId, nextCost));
                }
            }
        }
        return costs.get(end);
    }


}
