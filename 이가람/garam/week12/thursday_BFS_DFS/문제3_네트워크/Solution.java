package garam.week12.thursday_BFS_DFS.문제3_네트워크;

public class Solution {

    public static void main(String[] args) {

        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(3, computers1)); // 출력: 2

//        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
//        System.out.println(solution(3, computers2)); // 출력: 1

    }

    public static int solution(int n, int[][] computers) {
        if (computers == null || computers.length == 0 || computers[0].length == 0) {
            return 0;
        }

        int count = 0; // 연결된 네트워크의 수를 세기 위한 변수

        // 모든 컴퓨터를 순회
        for (int i = 0; i < n; i++) {
            if (computers[i][i] == 1) { // 아직 방문하지 않은 컴퓨터를 찾으면
                dfs(n, i, computers); // DFS로 네트워크 탐색을 시작
                count++; // 하나의 네트워크를 발견했으므로 카운트를 증가
            }
        }

        return count; // 발견된 네트워크의 총 수를 반환
    }

    public static void dfs(int n, int i, int[][] computers) {
        // 현재 컴퓨터를 방문 처리
        computers[i][i] = 0;

        // 다른 모든 컴퓨터에 대해 확인
        for (int j = 0; j < n; j++) {
            // 현재 컴퓨터와 연결된 컴퓨터가 방문되지 않았다면
            if (computers[i][j] == 1 && computers[j][j] == 1) {
                dfs(n, j, computers); // 해당 컴퓨터에 대해 DFS 탐색을 진행
            }
        }
    }
}
