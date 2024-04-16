package garam.week15;

import java.util.*;

public class 입국심사 {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[]{7, 10})); // expect 28
	}

	public static long solution(int n, int[] times) {

		long left = 1;
		long right = (long) Arrays.stream(times).max().getAsInt() * n; // 최대 가능 시간
		long answer = right;

		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;

			// mid 시간동안 처리할 수 있는 사람 수 계산
			for (int time : times) {
				count += mid / time;
				if (count >= n) break; // 필요한 사람 수를 넘으면 바로 중단
			}

			// 처리 가능한 사람 수가 더 많다면 시간을 줄여본다
			if (count >= n) {
				answer = mid;
				right = mid - 1;
			} else { // 그렇지 않다면 시간을 늘린다
				left = mid + 1;
			}
		}

		return answer;
	}
}
