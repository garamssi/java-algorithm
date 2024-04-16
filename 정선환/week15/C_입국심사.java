package week15;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43238
 * 입국 심사
 */
public class C_입국심사 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long left = 1;
        long right = times[(times.length - 1)] * (long) n;

        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for(int time : times) {
                sum += mid / time;
            }

            if (sum < n)
                left = mid + 1;
            else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;

    }

}
