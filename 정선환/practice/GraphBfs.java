package practice;

import java.util.*;

public class GraphBfs {

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', List.of('B', 'D', 'E'));
        graph.put('B', List.of('A', 'C', 'D'));
        graph.put('C', List.of('B'));
        graph.put('D', List.of('A', 'B'));
        graph.put('E', List.of('A'));

        bfs(graph, 'A');

        System.out.println(visited);
    }

    static HashMap<Character, Boolean> visited = new HashMap<>();

    public static void bfs(Map<Character, List<Character>> graph, Character startVertex) {
        // vertex 방문
        visited.put(startVertex, true);

        Queue<Character> queue = new LinkedList<>();
        queue.offer(startVertex);

        while(!queue.isEmpty()) {
            Character currentVertex = queue.poll();
            List<Character> relationVertex = graph.get(currentVertex);
            for (Character vertex : relationVertex) {
                if(!visited.containsKey(vertex)) {
                    visited.put(vertex, true);
                    queue.offer(vertex);
                }
            }
        }
    }
}
