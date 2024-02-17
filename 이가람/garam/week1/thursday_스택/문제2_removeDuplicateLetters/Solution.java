package garam.week1.thursday.문제2_removeDuplicateLetters;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    // 스택으로 이용한 문제 풀이
    public static String removeDuplicateLetters(String s) {

        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        /** 맵에 '문자':개수를 입력합니다. */
        for (char c : s.toCharArray()) {
            counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);
        }

        for (char c : s.toCharArray()) {
            // 카운터에서 시작 문자의 값을 하나 -1을 합니다.
            counter.put(c, counter.get(c) - 1);

            /** seen에 이미 추가되어있고 비교하려는 문자가 같다면 스킵 */
//            if (seen.get(c) != null && seen.get(c) == true) {
//                continue;
//            }
            if (seen.get(c) != null) {
                continue;
            }

            /**
             * 1. 스택에 값이 있다.
             * 2. 스택의 첫 번째 값과 c를 비교한다.
             * 3. counter에 가지고 있는 값이 1개 이상인지 확인한다.
             * 이는 seen에는 앞에 더 문자가 있다는 표시를 해주고
             * stack에서 값을 제거하여 스택 내부의 문자 순서를 변경시킨다.
             *
             * */
            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
//                seen.put(stack.pop(), false);
                Character removeKey = stack.pop();
                seen.remove(removeKey);
            }

            stack.push(c);
            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }


}
