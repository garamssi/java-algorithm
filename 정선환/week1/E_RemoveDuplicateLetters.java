package week1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

/**
 * RemoveDuplicateLetters (중복 문자 제거)
 *
 * 중복된 문자를 제외하고 사전식 순서로 나열하라
 * 입력: dbacdcbc
 * 출력: acdb
 *
 * https://leetcode.com/problems/valid-parentheses/
 */
public class E_RemoveDuplicateLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        removeDuplicateLetters(input);
    }

    public static String removeDuplicateLetters(String s) {
        // 문자 개수를 계산해서 담아올 변수
        HashMap<Character, Integer> counter = new HashMap<>();

        // 이미 처리한 문자 여부를 확인하기 위한 변수
        HashMap<Character, Boolean> seen = new HashMap<>();

        // 문제 풀이에 사용할 스텍 선언
        Deque<Character> stack = new ArrayDeque<>();

        // 문자열 개수 계산
        for (char c : s.toCharArray()) {
            counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);
        }

        for (char c : s.toCharArray()) {
            // 현재 처리하는 문자는 카운터에서 -1 처리
            counter.put(c, counter.get(c) - 1);

            // 이미 처리한 문자는 건너뜀
            if(seen.get(c) != null && seen.get(c) == true) {
                continue;
            }

            // 스택에 있는 문자가 현재 문자보다 더 뒤에 붙여야 할 문자라면 스택에서 제거하고
            // 처리하지 않은 걸로 표시
            while(!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                seen.put(stack.pop(), false);
            }

            // 현재 문자를 스택에 삽입
            stack.push(c);

            // 현재 문자를 처리한 걸로 선언
            seen.put(c, true);
        }

        // 스택에 있는 문자를 큐 순서대로 추출하여 리턴
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

}
