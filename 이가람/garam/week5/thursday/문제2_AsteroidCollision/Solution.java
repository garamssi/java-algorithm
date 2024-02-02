package garam.week5.thursday.문제2_AsteroidCollision;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 *
 * 행성 충돌
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(asteroidCollision(new int[]{5, 10, -5}));
//        System.out.println(asteroidCollision(new int[]{-2, -2, -1, -2}));
//        System.out.println(asteroidCollision(new int[]{10,2,-5}));
//        System.out.println(asteroidCollision(new int[]{-2, -2, 1, -2}));
        System.out.println(asteroidCollision(new int[]{1,-2,-2,-2}));
    }

    public static int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(asteroids[0]);

        for (int i = 1; i < asteroids.length; i++) {

            Integer asteroid = deque.peekLast();

            // 큐가 비어있으면 추가하고 다음 것으로
            if ( asteroid == null) {
                deque.offer(asteroids[i]);
                continue;
            }

            // 이전 소행성이 양수 && 이번 소행성이 음수
            if (asteroid > 0 && asteroids[i] < 0 ) {
                // 현재 행성이 충돌이 됐는지 여부 변수
                boolean x = false;

                while (!deque.isEmpty()) {

                    Integer a = deque.peekLast();

                    // 이전 소행성이 양수 && 이번 소행성이 음수
                    if (a > 0 && asteroids[i] < 0) {
                        // 1. a가 더 큰 행성이면 취소.
                        if (a > Math.abs(asteroids[i])) {
                            x = true;
                            break;
                        }
                        // 양수와 음수가 같은 크기일 때 둘이 충돌하여 같이 사라짐
                        else if (a == Math.abs(asteroids[i])) {
                            deque.pollLast();
                            x = true;
                            break;
                        }
                        // asteroids[i]이 더 큰 행성일 경우에 큐 마지막 요소를 제거
                        else {
                            deque.pollLast();
                        }
                    }
                    else {
                        deque.offer(asteroids[i]);
                        break;
                    }
                }

                // 큐는 비어있지만 행성 충돌이 안된 소행성
                if(!x){
                    deque.offer(asteroids[i]);
                }
            } else {
                deque.offer(asteroids[i]);
            }
        }

        return deque.stream().mapToInt(Integer::intValue).toArray();

    }
}
