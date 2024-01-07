package garam.week1.thursday.문제3_dailyTemperatures;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {


    public static void main(String[] args) {
        System.out.println(dailyTemperatures(new int[]{23, 24, 25, 21, 19, 22, 26, 23}));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int last = stack.pop();

                result[last] = i - last;
            }

            stack.push(i);
        }

        return result;
    }

}
