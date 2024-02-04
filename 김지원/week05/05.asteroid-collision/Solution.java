import java.util.Arrays;
import java.util.Stack;

class Solution {
    
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] rs = new Solution().asteroidCollision(asteroids);
        System.out.println(Arrays.toString(rs));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean explodedCurrentAsteroid = false;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int collided = stack.peek() + asteroid; // 소행성 충돌 시도
                if (collided > 0) { // 뒤쪽 소행성 파괴
                    explodedCurrentAsteroid = true;
                    break;
                } else if (collided < 0) { // 앞쪽 소행성 파괴
                    stack.pop();
                } else { // 소행성 둘다 파괴
                    stack.pop();
                    explodedCurrentAsteroid = true;
                    break;
                }
            }
            if (!explodedCurrentAsteroid) {
                stack.push(asteroid);
            }
        }

        int[] remainedAsteroids = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            remainedAsteroids[i] = stack.pop();
            i--;
        }
        return remainedAsteroids;
    }
}