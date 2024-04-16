import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] wires) {
        int[][] graph = new int[n + 1][n + 1];
        int answer = 101;

        for (int[] wire : wires) {
            int from = wire[0], to = wire[1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for (int[] wire : wires) {
            int from = wire[0], to = wire[1];
            // 전선을 하나 끊어본다.
            graph[from][to] = 0;
            graph[to][from] = 0;

            answer = Math.min(answer, bfs(graph, n));

            // 전선을 다시 연결한다.
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        return answer;
    }

    // 송전탑 개수의 차이를 구한다.
    private int bfs(int[][] graph, int n) {
        int start = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next = 1; next <= n; next++) {
                if (graph[now][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    count++;
                    q.offer(next);
                }
            }
        }
        return Math.abs(n - count * 2);
    }
}