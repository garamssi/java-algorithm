package garam.week14;

import java.util.*;

public class 문제1_가장먼노드 {

    public static void main(String[] args) {
        solution(5, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }

    public static int solution(int n, int[][] results) {

        final int INF = 1000000000; // 무한대 값을 나타내는 상수
        int[][] graph = new int[n + 1][n + 1];

        // 그래프 초기화: 자기 자신으로의 경로는 0, 그 외는 INF로 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }

        // 결과 입력을 통한 그래프 초기화: 승리 = 1, 패배 = -1
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1; // 승리
            graph[result[1]][result[0]] = -1; // 패배
        }

        // 플로이드-워셜 알고리즘을 사용하여 각 선수간의 승패 관계 분석
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    } else if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                    }
                }
            }
        }

        // 순위를 정확히 알 수 있는 선수의 수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean isDeterminable = true;
            for (int j = 1; j <= n; j++) {
                if (i != j && graph[i][j] == INF) {
                    isDeterminable = false;
                    break;
                }
            }
            if (isDeterminable) answer++;
        }

        return answer;
    }
}
