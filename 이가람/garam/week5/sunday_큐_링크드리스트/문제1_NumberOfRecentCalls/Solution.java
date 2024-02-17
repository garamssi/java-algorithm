package garam.week5.sunday_큐_링크드리스트.문제1_NumberOfRecentCalls;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-recent-calls/?envType=study-plan-v2&envId=leetcode-75
 *
 * RecentCounter특정 기간 내의 최근 요청 수를 계산하는 클래스가 있습니다.
 * RecentCounter()최근 요청이 없는 카운터를 초기화합니다.
 * int ping(int t)t밀리초 단위의 시간을 나타내는 time 에 새 요청을 추가 t하고 지난 밀리초 동안 발생한 요청 수 3000(새 요청 포함)를 반환합니다.
 * 구체적으로, 포함 범위에서 발생한 요청 수를 반환합니다 [t - 3000, t].
 *
 *
 * 테스트 케이스를 작성하고 싶지만 어려움.....
 */
public class Solution {


	public static void main(String[] args) {
		RecentCounter();
		ping(1);
		ping(100);
		ping(3001);
		ping(3002);

		System.out.println(requests);
	}

	private static Queue<Integer> requests;

	public static void RecentCounter() {
		requests = new LinkedList<>();
	}

	public static int ping(int t) {
		requests.add(t);
		while (requests.peek() < t - 3000) {
			requests.poll();
		}
		return requests.size();
	}



}
