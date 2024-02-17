package garam.week5.thursday_스택.문제1_RemovingStarsFromAString;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 입력: s = "leet**cod*e"
 *  출력: "lecoe"
 *  설명: 왼쪽에서 오른쪽으로 제거를 수행합니다.
 *  -첫 번째 별에 가장 가까운 문자는 "lee t **cod*e" 의 't'입니다 . s는 "lee*cod*e"가 됩니다.
 *  - 두 번째 별에 가장 가까운 문자는 "le e *cod*e" 의 'e'입니다 . s는 "lecod*e"가 됩니다.
 *  - 3 번째 별에 가장 가까운 문자는 "leco d *e" 의 'd'입니다 . s는 "lecoe"가 됩니다.
 * 더 이상 별이 없으므로 "lecoe"를 반환합니다.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }

    public static String removeStars(String s) {


        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                deque.pollLast();
            } else {
                deque.offer(s.charAt(i));
            }
        }

        StringBuilder ss = new StringBuilder();
        while (!deque.isEmpty()) {
            ss.append(deque.pop());
        }

        return ss.toString();
    }
}
