package garam.week9.thursday_DP.문제1_uniquePaths;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        uniquePaths(5,5);

    }

    public static int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];

        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return dp(memo, m - 1, n - 1);
    }

    public static int dp(int[][] memo, int r, int c){
        int uniquePath = 0;

        if (r == 0 && c ==0) {
            memo[r][c] = 1;
            return memo[r][c];
        }

        if (memo[r][c] == -1) {
            if((r - 1) >= 0){
                uniquePath += dp(memo, r - 1, c);
            }
            if((c - 1) >= 0){
                uniquePath += dp(memo, r, c - 1);
            }
            memo[r][c] = uniquePath;
        }
        return memo[r][c];
    }
}
