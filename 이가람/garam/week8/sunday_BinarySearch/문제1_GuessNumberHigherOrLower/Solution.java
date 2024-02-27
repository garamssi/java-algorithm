package garam.week8.sunday_BinarySearch.문제1_GuessNumberHigherOrLower;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 값을 받으면 맞추는 문제,
 */
public class Solution {

	private static int num = 0;

	public static void main(String[] args) {
		num = 6;
		guessNumber(10);
	}

	public static int guessNumber(int n) {
		// 탐색 범위의 시작점
		int left = 1;
		// 탐색 범위의 끝점
		int right = n;

		// 이진 탐색 시작: low가 high보다 작거나 같을 때까지 반복
		while(left <= right){
			// low와 high의 중간 값(오버플로우 방지)
			int mid = left + (right - left) / 2;
			// guess 함수 호출로 mid와 사용자가 생각하는 숫자 비교
			int pick = guess(mid);

			// pick > 0: 추측한 숫자가 작음, 탐색 범위를 높은 쪽으로 조정
			if(pick > 0) left = mid + 1;
				// pick < 0: 추측한 숫자가 큼, 탐색 범위를 낮은 쪽으로 조정
			else if(pick < 0) right = mid - 1;
				// pick == 0: 숫자를 맞춤, mid 반환
			else return mid;

		}
		// 탐색 실패 시 -1 반환
		return -1;
	}

	public static int guess(int pick) {
		if (num < pick) return -1;
		else if (num > pick) return 1;
		else return 0; // num == pick
	}

}
