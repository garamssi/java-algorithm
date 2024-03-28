package garam.week13.tuesday_스택_큐.문제1_올바른괄호;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
	}

	private static boolean solution(String s){
		if(s.length() == 0 || s.length() == 1){
			return false;
		}

		Deque<Character> stack = new ArrayDeque<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {
				stack.offer(c);
			} else if (c == ')' && stack.peekLast() == '(') {
				stack.pollLast();
			} else {
				stack.offer(c);
			}
		}

		return stack.isEmpty();
	}
}
