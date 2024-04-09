package garam.week13.thursday_DP.문제2_정수삼각형;

import java.util.*;

public class Solution {

    public Map<Integer,Boolean> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    private static int solution(int[][] triangle) {
        // 삼각형의 높이
        int height = triangle.length;

        // 누적 합을 저장할 배열, 각 위치까지의 최대 합을 저장
        int[][] dp = new int[height][height]; // 삼각형과 같은 크기로 dp 배열 초기화

        // 맨 위층 초기화
        dp[0][0] = triangle[0][0];

        // 삼각형의 두 번째 줄부터 마지막 줄까지 순회
        for (int i = 1; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 맨 왼쪽일 경우, 바로 위의 값만 더할 수 있음
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == i) {
                    // 맨 오른쪽일 경우, 왼쪽 대각선 위의 값만 더할 수 있음
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    // 그 외의 경우, 위의 두 경우를 비교하여 더 큰 값 선택
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        // 마지막 줄에서 최대값 찾기
        int maxSum = 0;
        for (int num : dp[height-1]) {
            maxSum = Math.max(maxSum, num);
        }

        return maxSum;
    }


}
