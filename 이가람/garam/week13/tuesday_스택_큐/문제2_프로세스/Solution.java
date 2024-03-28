package garam.week13.tuesday_스택_큐.문제2_프로세스;

import java.util.*;

public class Solution {
	public static void main(String[] args) {

	}

	private static int solution(int[] priorities, int location) {
		// 프로세스의 인덱스와 우선순위를 저장하는 큐
		Queue<int[]> processQueue = new LinkedList<>();
		// 우선순위를 기준으로 정렬할 우선순위 큐 (int[]의 첫 번째 요소를 기준으로 정렬)
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
			(p1, p2) -> p2[0] - p1[0]
		);

		for (int i = 0; i < priorities.length; i++) {
			int[] process = new int[]{priorities[i], i};
			processQueue.offer(process);
			priorityQueue.offer(process);
		}

		int cnt = 0; // 현재까지 실행된 프로세스의 수

		while (!processQueue.isEmpty()) {
			int[] current = processQueue.poll();
			if (current[0] == priorityQueue.peek()[0]) { // 현재 프로세스가 가장 높은 우선순위인 경우
				cnt++;
				priorityQueue.poll();
				if (current[1] == location) {
					return cnt; // 찾고자 하는 프로세스가 실행됐다면 그 순서를 반환
				}
			} else {
				processQueue.offer(current); // 아니면 큐의 끝으로
			}
		}

		return cnt;
	}
}
