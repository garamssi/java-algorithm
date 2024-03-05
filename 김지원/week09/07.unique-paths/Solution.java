// f(0, 0) = 1
// f(x, y) = f(x-1, y) + f(x, y-1)
class Solution {
    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        dp[0][0] = 1;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (x - 1 >= 0 && x - 1 < m) {
                    dp[x][y] += dp[x - 1][y];
                }

                if (y - 1 >= 0 && y - 1 < n) {
                    dp[x][y] += dp[x][y - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}