package week13;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 * 주식 가격
 */
public class C_주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for(int j = i + 1; j < prices.length; j++) {
                count++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

}
