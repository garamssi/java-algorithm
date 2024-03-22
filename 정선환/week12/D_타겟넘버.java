package week12;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * 타겟 넘버
 */
public class D_타겟넘버 {
    public static void main(String[] args) {
//        int[] numbers = {1, 1, 1, 1, 1};
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target);
        return count;
    }

    static int count = 0;
    public static void dfs(int[] numbers, int start, int target) {
        // 합계 비교
        int sum = Arrays.stream(numbers).sum();
        if(sum == target) {
            count++;
        }

        for(int i = start; i < numbers.length; i++) {
            int[] temp = Arrays.copyOf(numbers, numbers.length);
            temp[i] *= -1;

            dfs(temp, i + 1, target);
        }
    }
}
