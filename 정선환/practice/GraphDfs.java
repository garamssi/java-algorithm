package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphDfs {
    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', List.of('B', 'D', 'E'));
        graph.put('B', List.of('A', 'C', 'D'));
        graph.put('C', List.of('B'));
        graph.put('D', List.of('A', 'B'));
        graph.put('E', List.of('A'));

        dfs(graph, 'A');
        System.out.println(visited);
    }

    static Map<Character, Boolean> visited = new HashMap<>();
    public static void dfs(Map<Character, List<Character>> graph, Character currentVertex) {

        // vertex 방문
        visited.put(currentVertex, true);

        List<Character> characters = graph.get(currentVertex);
        for (Character character : characters) {
            if(!visited.containsKey(character)) {
                dfs(graph, character);
            }
        }
    }
}
