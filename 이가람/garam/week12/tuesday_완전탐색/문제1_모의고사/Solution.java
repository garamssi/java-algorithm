package garam.week12.tuesday_완전탐색.문제1_모의고사;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[] answers1 = {1, 2, 3, 4, 5};
		int[] answers2 = {1, 3, 2, 4, 2};

		int[] solution1 = solution(answers1);
		int[] solution2 = solution(answers2);

		System.out.println(solution1); // [1]
		System.out.println(solution2); // [1, 2]
	}

	public static int[] solution(int[] answers) {
		int[][] patterns = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};
		int[] scores = new int[3];

		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < patterns.length; j++) {
				if (answers[i] == patterns[j][i % patterns[j].length]) {
					scores[j]++;
				}
			}
		}

		int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < scores.length; i++) {
			if (scores[i] == maxScore) {
				list.add(i + 1);
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
	}
}
