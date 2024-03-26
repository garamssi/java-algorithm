package garam.week12.sunday_완전탐색.문제3_피로도;

public class Solution {
	public static int answer = 0;

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		int result = solution(k, dungeons);
		System.out.println(result); // 결과 출력
	}

	private static int solution(int k, int[][] dungeons) {
		boolean[] visited = new boolean[dungeons.length];
		dfs(k, dungeons, visited, 0);
		return answer;
	}

	private static void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
		for (int i = 0; i < dungeons.length; i++) {
			// 방문하지 않은 곳, 그리고 남은 피로도 이하인 곳
			if (!visited[i] && k >= dungeons[i][0]) {
				visited[i] = true;
				// 남은 피로도, 던전, 방문, 카운트 + 1
				dfs(k - dungeons[i][1], dungeons, visited, count + 1);
				visited[i] = false;
			}
		}
		answer = Math.max(answer, count);
	}
}
