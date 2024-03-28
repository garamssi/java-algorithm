package garam.week13.tuesday_스택_큐.문제3_주식가격;

public class Solution {
	public static void main(String[] args) {
		solution(new int[]{1, 2, 3, 2, 3});
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			// 첫 시작은 가격이 떨어지지 않음
			for (int j = i + 1; j < prices.length; j++) {
				answer[i]++;
				if (prices[i] > prices[j]) {
					break;
				}
			}
		}

		return answer;
	}
}
