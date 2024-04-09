package garam.week13.thursday_DP.문제3_등굣길;

public class Solution {
    public static void main(String[] args) {
        solution(4, 3, new int[][]{{2,2}});
    }

    private static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1]; // 격자를 생성, (1,1)부터 시작하기 위해 +1

        // 물웅덩이 위치 표시, 물웅덩이는 -1로 표시
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1; // x,y 위치 조정
        }

        dp[1][1] = 1; // 시작점 초기화

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) { // 물웅덩이는 경로에서 제외
                    dp[i][j] = 0;
                    continue;
                }
                if (i != 1) dp[i][j] += dp[i-1][j] % 1000000007; // 위에서 오는 경우의 수 추가
                if (j != 1) dp[i][j] += dp[i][j-1] % 1000000007; // 왼쪽에서 오는 경우의 수 추가
            }
        }

        return dp[n][m] % 1000000007; // 최종 경로의 수를 1,000,000,007로 나눈 나머지 반환
    }
}
