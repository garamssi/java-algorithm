package garam.week11.thursday_BFS_DFS.문제1_타켓넘버;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int result = solution.solution(nums, target);
        System.out.println(result);
    }
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs(nums, target, index + 1, sum + nums[index]) +
                dfs(nums, target, index + 1, sum - nums[index]);
    }
    /**
     * 1+1+1+1+1
     * 1+1+1+1-1
     * 1+1+1-1+1
     * 1+1-1+1+1
     * 1+1-1+1-1
     * 1+1-1-1-1
     */


}
