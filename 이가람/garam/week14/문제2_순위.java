package garam.week14;

import java.util.*;

public class 문제2_순위 {
    public static void main(String[] args) {
        solution(6, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }

    public static int solution(int n, int[][] edge) {
        // 각 노드가 연결된 정보를 저장할 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 주어진 edge 정보를 바탕으로 양방향 그래프 구성
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // 노드 방문 정보와 거리 정보를 저장할 배열 초기화
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); // 거리 정보를 -1로 초기화

        // BFS 실행
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 1번 노드부터 시작
        visited[1] = true;
        distance[1] = 0; // 1번 노드의 거리는 0

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    distance[next] = distance[current] + 1;
                }
            }
        }

        // 최대 거리 찾기
        int maxDistance = Arrays.stream(distance).max().getAsInt();
        // 최대 거리를 가진 노드의 수를 카운트
        int answer = (int) Arrays.stream(distance).filter(d -> d == maxDistance).count();

        return answer;
    }
}
