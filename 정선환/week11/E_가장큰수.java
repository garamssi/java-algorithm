package week11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * 가장 큰 수
 */
public class E_가장큰수 {
    public static void main(String[] args) {
//        int[] numbers = {6, 10, 2}; // 6210
        int[] numbers = {3, 30, 34, 5, 9}; // 9534330

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;
                
                return ba.compareTo(ab);
            }
        });

        StringBuilder answer = new StringBuilder();
        for (String num : nums) {
            answer.append(num);
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}
