package garam.week13.sunday_그리디.문제2_큰수만들기;

public class Solution {
	public static int result = Integer.MIN_VALUE;

	public static void main(String[] args) {
//		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
	}

	public static String solution(String number, int k) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = number.length(); i < len; i++) {
			char c = number.charAt(i);
			while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c) {
				sb.deleteCharAt(sb.length() - 1);
				k--;
			}
			sb.append(c);
		}

		// 만약 k가 남았다면, 뒤에서부터 k개 문자 제거
		return sb.substring(0, sb.length() - k);
	}
}
