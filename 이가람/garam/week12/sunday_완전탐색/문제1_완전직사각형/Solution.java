package garam.week12.sunday_완전탐색.문제1_완전직사각형;

public class Solution {
	public static void main(String[] args) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		System.out.println(solution(sizes));
	}

	public static int solution(int[][] sizes) {

		int maxWidth = 0;
		int maxHeight = 0;
		for (int[] card : sizes) {
			int max = Math.max(card[0], card[1]);
			int min = Math.min(card[0], card[1]);

			maxWidth = Math.max(maxWidth, max);
			maxHeight = Math.max(maxHeight, min);
		}

		return maxWidth * maxHeight;
	}

}
