package garam.week13.thursday_DP.문제1_N으로표현;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(5, 12));
//        System.out.println(solution(2, 11));
    }

    private static int solution(int N, int number) {
        if (N == number) {
            return 1; // N과 number가 같으면 N을 한 번만 사용해도 되므로 1 반환
        }

        // dp 배열은 각각 N을 i번 사용하여 만들 수 있는 모든 수를 저장
        Set<Integer>[] dp = new Set[9];
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
            int nValue = Integer.parseInt(Integer.toString(N).repeat(i)); // N, NN, NNN... 형태로 초기화
            dp[i].add(nValue);

            for (int j = 1; j < i; j++) {
                for (Integer a : dp[j]) {
                    for (Integer b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) dp[i].add(a / b);
                    }
                }
            }

            if (dp[i].contains(number)) {
                return i; // number를 만들 수 있는 경우 해당 사용 횟수 반환
            }
        }

        return -1; // 8번 내로 표현할 수 없는 경우 -1 반환
    }
}
