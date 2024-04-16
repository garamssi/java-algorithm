package garam.week15;

import java.util.*;

public class 전력망을둘로나누기 {

	// 그래프를 표현하기 위한 리스트
	private static List<List<Integer>> graph = new ArrayList<>();;
	// 해당 노드 방문 여부를 확인할 배열
	private static boolean[] visited;

	public static void main(String[] args) {
		solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
	}

	public static int solution(int n, int[][] wires) {
		int answer = n; // 노드 수의 최대 차이는 n이 될 수 있으므로 초기값을 n으로 설정

		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 그래프 구성
		for(int[] wire : wires) {
			int a = wire[0];
			int b = wire[1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		// 각 연결을 하나씩 끊어보며 최소 차이를 계산
		for(int[] wire : wires) {
			int a = wire[0];
			int b = wire[1];

			// 연결 끊기
			graph.get(a).remove((Integer) b);
			graph.get(b).remove((Integer) a);

			// 노드 방문 여부 초기화
			visited = new boolean[n + 1];

			// a에서 시작하는 서브트리의 크기 구하기
			int count = dfs(a);

			// 두 그룹의 차이 계산
			int diff = Math.abs(n - 2 * count);
			if(diff < answer) {
				answer = diff;
			}

			// 연결 복구
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		return answer;
	}

	// 깊이 우선 탐색(DFS)를 이용하여 연결된 노드의 개수를 세는 함수
	private static int dfs(int node) {
		visited[node] = true;
		int size = 1; // 현재 노드를 포함하므로 크기는 1부터 시작

		for(int next : graph.get(node)) {
			if(!visited[next]) {
				size += dfs(next);
			}
		}

		return size;
	}
}
