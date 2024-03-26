package garam.week12.sunday_완전탐색.문제2_소수찾기;

import java.util.*;
public class Solution {
	private static Set<String> found = new HashSet<>(); // 중복된 조합을 방지하기 위해 사용

	public static void main(String[] args) {
		System.out.println(solution("17"));
	}

	private static int solution(String str) {
		StringBuilder result = new StringBuilder();
		dfs(result, str);
		return found.size(); // 찾은 소수의 개수를 반환
	}

	private static void dfs(StringBuilder result, String str) {
		if (result.length() > 0) {
			String resultStr = result.toString();
			if (!found.contains(resultStr)) { // 이미 찾은 조합이 아닐 경우에만 검사
				int num = Integer.parseInt(resultStr);
				if (isPrime(num)) {
					found.add(resultStr); // 소수이면 저장
				}
			}
		}

		for (int i = 0; i < str.length(); i++) {
			result.append(str.charAt(i));
			dfs(result, str.substring(0, i) + str.substring(i + 1)); // 현재 문자를 제외하고 재귀 호출
			result.deleteCharAt(result.length() - 1); // 마지막 문자 삭제
		}
	}
	private static boolean isPrime(int n) {
		if (n <= 1) return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}


