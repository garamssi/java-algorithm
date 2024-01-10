package week1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */
public class G_DailyTemperatures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input 데이터
        String numsString = sc.nextLine();
        int[] temperatures = Arrays.stream(numsString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] answer = dailyTemperatures(temperatures);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque();
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int preDay = stack.pop();
                int curDay = i - preDay;
                answer[preDay] = curDay;
            }

            stack.push(i);
        }

        return answer;
    }
}
