package week13;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * 기능개발
 */
public class A_기능개발 {
    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};

        int[] progresses = {};
        int[] speeds = {};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0) {
                day++;
            }

            queue.offer(day);
        }

        List<Integer> deployDays = new ArrayList<>();

        while(!queue.isEmpty()) {
            int deployCount = 1;
            int temp = queue.poll();

            while(!queue.isEmpty() && queue.peek() <= temp) {
                queue.poll();
                deployCount++;
            }

            deployDays.add(deployCount);
        }

        return deployDays.stream().mapToInt(Integer::intValue).toArray();
    }
}
