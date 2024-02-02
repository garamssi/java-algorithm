package week5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
 * 735. Asteroid Collision
 */
public class E_AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {1,-2,-2,-2};
        int[] answer = asteroidCollision(asteroids);
        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int length = asteroids.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < length; i++) {
            collisionCheck(stack, asteroids[i]);
        }

        // 정답 데이터 담기
        int[] answer = new int[stack.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = stack.pollLast();
        }
        return answer;
    }

    public static void collisionCheck(Deque<Integer> stack, int asteroid) {
        if(stack.isEmpty()) {
            stack.push(asteroid);
            return ;
        }

        Integer tempAsteroid = stack.peek();

        // 충돌 조건
        if(tempAsteroid > 0 && asteroid < 0) {
            int absPeek = Math.abs(tempAsteroid);
            int absAsteroid = Math.abs(asteroid);

            // 소행성 크기가 같으면 둘다 파괴
            if(absPeek == absAsteroid) {
                stack.pop();

            }
            if(absPeek < absAsteroid) {
                stack.pop();
                collisionCheck(stack, asteroid);
            }
        }else {
            stack.push(asteroid);
        }
    }
}
