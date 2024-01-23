package garam.week3.thursday.문제3_houseRobber;

import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/42897
public class Solution {

	public static void main(String[] args) {
		System.out.println(houseRobber(new int[]{1, 2, 3, 1}));
		System.out.println(houseRobber(new int[]{2, 7, 9, 3, 1}));
	}

	// 타뷸레이션(상향식)
	public static int houseRobber(int[] money) {
		// if 입력값이 1개인 경우 예외 처리
		if(money.length == 1) {
			return money[0];
		}

		int[][] dp = new int[2][money.length];
		dp[0][0] = 0; // 첫 번째 값은 사용하지 않음
		dp[1][0] = 0;
		dp[0][1] = 0; // 두 번째 값도 사용하지 않음
		dp[1][1] = money[1];
		// 이전 결과와 (전전 결과 + 현재결과) 중 큰 값 저장, 두 번째 값 사용 유무에 따라 별도 계산
		for(int i = 2; i < money.length; i++) {
			dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + money[i]);
			dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + money[i]);
		}

		return Math.max(money[0] + dp[0][money.length - 2], dp[1][money.length - 1]);
	}
}
