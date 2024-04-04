// dp[i][j]: (i,j)에 도달 할 수 있는 방법의 수
// dp[i][j] = dp[i-1][j](위쪽에서 오는 경우의 가지수) + dp[i][j-1](왼쪽에서 오는 경우의 가지수)

class Solution {
    private static final int PUDDLE = -1;
    private static final int DIVISOR = 1_000_000_007;

    public int solution(int column, int row, int[][] puddles) {
        int[][] dp = new int[row][column];
        dp[0][0] = 1;
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = PUDDLE;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 집의 좌표는 제외
                if (i == 0 && j == 0) {
                    continue;
                }
                // 웅덩이인 경우
                if (dp[i][j] == PUDDLE) {
                    continue;
                }
                // 위에서 오는 경우
                int top = i - 1 >= 0 && dp[i - 1][j] != PUDDLE ? dp[i - 1][j] : 0;

                // 왼쪽에서 오는 경우
                int left = j - 1 >= 0 && dp[i][j - 1] != PUDDLE ? dp[i][j - 1] : 0;

                dp[i][j] = (top + left) % DIVISOR;
            }
        }

        return dp[row - 1][column - 1] % DIVISOR;
    }
}