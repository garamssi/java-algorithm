package garam.week13.sunday_그리디.문제1_조이스틱;

public class Solution {
	public static void main(String[] args) {
		System.out.println(solution("JAZ"));
//		System.out.println(solution("JEROEN"));
	}

	public static int solution(String name) {
		int answer = 0;
		int length = name.length();
		int minMove = length - 1; // 최대로 가질 수 있는 최소 이동 횟수는 길이 - 1

		for(int i = 0; i < length; i++) {
			// 상하 이동에 대한 최소값 계산
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

			// 현재 문자 다음부터 연속된 A의 마지막 인덱스 찾기
			int nextIndex = i+1;
			while (nextIndex < length && name.charAt(nextIndex) == 'A') {
				nextIndex++;
			}

			// 좌우 이동에 대한 최소값 계산
			// i * 2는 다시 돌아가는 것을 고려한 것이고, length - nextIndex는 끝에서 연속된 A를 제외한 나머지 문자를 방문하는 횟수
			minMove = Math.min(minMove, i * 2 + length - nextIndex);
			minMove = Math.min(minMove, (length - nextIndex) * 2 + i);
		}

		// 총 이동 횟수 = 상하 이동 횟수 + 좌우 이동 횟수
		answer += minMove;

		return answer;


	}
	/**
	 * i * 2 + length - nextIndex: 이 경우는 현재 위치에서 오른쪽으로 이동한 다음, 다시 왼쪽으로 돌아가서 남은 문자를 처리하는 상황을 다룹니다.
	 * 여기서 i * 2는 현재 위치에서 시작하여 오른쪽으로 이동한 후, 다시 시작점으로 돌아오기 위해 이동한 거리입니다.
	 * 이후 length - nextIndex는 마지막으로 방문해야 하는 문자까지 오른쪽에서 왼쪽으로 이동하는 거리를 나타냅니다.
	 * 이 경우는, 예를 들어, 시작 위치에서 몇 글자를 수정한 후, 다시 시작점으로 돌아가 다른 방향으로 이동해 나머지 글자들을 처리할 때 유리합니다.
	 *
	 * (length - nextIndex) * 2 + i: 이 경우는 처음에 오른쪽으로 이동하지 않고, 끝에서 남은 문자까지 이동한 후,
	 * 다시 뒤로 돌아와서 처음부터 시작점까지의 남은 문자를 처리하는 상황을 고려합니다.
	 * 여기서 length - nextIndex는 처음부터 연속된 'A'가 아닌 마지막 문자까지 이동하는 거리입니다.
	 */
}
