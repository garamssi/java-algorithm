package garam.week12.tuesday_완전탐색.문제2_카펫;

public class Solution {
	public static void main(String[] args) {
		solution(10, 2);    // 4,3
//		solution(24, 24);   // 8,6

	}

	public static int[] solution(int brown, int yellow) {
		// 갈색과 노란색 격자의 총 개수를 합산하여 totalCnt에 저장합니다.
		int totalCnt = brown + yellow;
		int width  = 0;
		int height = 0;

		// 가능한 모든 직사각형을 검사합니다.
		for (int i = 1; i <= totalCnt; i++) {
			// totalCnt를 i로 나누어 떨어지는 경우는 가로 길이로 가능한 값을 찾는 것
			// 만약 나누어 떨어지지 않는다면, 가로 길이로는 해당 값이 될 수 없기 때문에 무시
			if (totalCnt % i == 0) { // 가로로 나누어 떨어지는 경우
				int j = totalCnt / i; // 세로를 계산
				// 노란색 격자의 수가 해당 직사각형의 내부에 위치한 노란색 격자들의 수와 일치하는지
				if ((i - 2) * (j - 2) == yellow) {
					// 조건을 만족하는 직사각형의 가로와 세로 값을 저장합니다.
					width = j;
					height = i;
					break; // 직사각형을 찾았으므로 반복문을 종료합니다.
				}
			}
		}

		// 가로와 세로 길이를 포함한 배열을 반환합니다.
		return new int[]{width, height};
	}
}
