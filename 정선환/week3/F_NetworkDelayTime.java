package week3;

import java.util.*;

/**
 * https://leetcode.com/problems/network-delay-time/description/
 * 네트워크 딜레이 타임
 */
public class F_NetworkDelayTime {
    public static void main(String[] args) {
//        int[][] times = {
//                {2, 1, 1},
//                {2, 3, 1},
//                {3, 4, 1},
//        };
//        System.out.println(networkDelayTime(times, 4, 2));

//        int[][] times = {
//                {1,2,1}
//        };
//        System.out.println(networkDelayTime(times, 2, 1));

        int[][] times = {
                {1, 2, 1},
                {2, 3, 2}
        };
        System.out.println(networkDelayTime(times, 3, 1));

        // Fail Case
//        int[][] times = {
//                {1,2,1}
//        };
//        System.out.println(networkDelayTime(times, 2, 2));

    }

    static class Node {
        int nodeId, distance;
        public Node(int nodeId, int distance){
            this.nodeId = nodeId;
            this.distance = distance;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        // 배열 데이터를 그래프로 가공
        List<List<Node>> graph = new ArrayList<>(n + 1);
        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] time: times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new Node(v, w));
        }

        // 다익스트라
        Map<Integer, Integer> costs = new HashMap<>();
        Queue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.distance, o2.distance));

        priorityQueue.offer(new Node(n, k));

        int distance = 0;
        while(!priorityQueue.isEmpty()) {
            Node currNode = priorityQueue.poll();
            if(!costs.containsKey(currNode.nodeId)) {
                costs.put(currNode.nodeId, currNode.distance);

                List<Node> nodes = graph.get(k);
                for (Node node : nodes) {
                    distance += node.distance;
                }
            }
        }
        return distance == 0 ? -1 : distance;
    }
}
