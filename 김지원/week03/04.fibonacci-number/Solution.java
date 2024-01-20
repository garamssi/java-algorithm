class Solution {

    int[] dp;

    // f(n) = f(n-1) + f(n-2)
    // f(0) = 0;
    // f(1) = 1;
    public int fib(int n) {

        if (n < 2) {
            return n;
        }
        
        dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}