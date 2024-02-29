package garam.week9.tuesday_DP.문제3_HouseRobber;


/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75
 * 자바 알고리즘 인터뷰 - 집도둑 829pg 참고
 *
 * 타뷸레이션 방식
 */
public class Solution {
    public static void main(String[] args) {

        System.out.println(houseRobber(new int[]{1, 2, 3, 1}));
        System.out.println(houseRobber(new int[]{2, 7, 9, 3, 1}));
    }

    public static int houseRobber(int[] nums) {
        // 입력 값이 한 개인 경우 예외 처리
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        // 이전 결과와 (전전 결과 + 현재 결과) 중 큰 값 저장
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        // 항상 최댓값이 저장되므로 마지막 값을 정답으로 리턴
        return dp[nums.length - 1];
    }


}
