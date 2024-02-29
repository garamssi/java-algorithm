package week9;

/**
 * https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=leetcode-75
 * 198. House Robber
 */
public class C_HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,22,21,15,1};
//        int[] nums = {1,1,1,6};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int beforeHome = dp[i - 1];
            int beforeBeforeHome = dp[i - 2] + nums[i];
            dp[i] = Math.max(beforeHome, beforeBeforeHome);
        }

        return dp[nums.length - 1];
    }
}
