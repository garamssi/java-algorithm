package week25;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1260
 * DFS와 BFS
 */
public class F_dfs와bfs {

    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer graphSt = new StringTokenizer(bf.readLine(), " ");
            int vertex1 = Integer.parseInt(graphSt.nextToken());
            int vertex2 = Integer.parseInt(graphSt.nextToken());

            graph[vertex1].add(vertex2);
            graph[vertex2].add(vertex1);

            Collections.sort(graph[vertex1]);
            Collections.sort(graph[vertex2]);
        }

        List<Integer> dfsResult = dfs(startVertex, visited);
        List<Integer> bfsResult = bfs(startVertex);

        for (Integer result : dfsResult) {
            bw.write(result + " ");
        }
            bw.write("\n");

        for (Integer result : bfsResult) {
            bw.write(result + " ");
        }

        bf.close();
        bw.flush();
        bw.close();
    }

    private static List<Integer> bfs(int startVertex) {
        // 1. vertex 방문
        List<Integer> visited = new ArrayList<>();
        visited.add(startVertex);

        // 2. Queue 대기열 추가
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);

        // 3. 큐를 루프 돌면서 방문안한 값을 찾음
        while(!queue.isEmpty()) {
            int currVertex = queue.poll();
            List<Integer> relationVertex = graph[currVertex];
            for (int vertex : relationVertex) {
                if(!visited.contains(vertex)) {
                    visited.add(vertex);
                    queue.offer(vertex);
                }
            }
        }

        return visited;

    }

    static List<Integer> visited = new ArrayList<>();
    private static List<Integer> dfs(int currVertex, List<Integer> visited) {
        // 1. vertex 방문
        visited.add(currVertex);

        List<Integer> relationVertex = graph[currVertex];
        for (int vertex : relationVertex) {
            if(!visited.contains(vertex)) {
                dfs(vertex, visited);
            }
        }

        return visited;
    }

}
