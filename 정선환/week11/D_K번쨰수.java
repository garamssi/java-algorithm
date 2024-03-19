package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * K번째 수
 */
public class D_K번쨰수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();

        for(int[] command: commands) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue();
            for(int i = command[0] - 1; i < command[1]; i++) {
                priorityQueue.offer(array[i]);
            }

            int answer = 0;
            for(int i = 0; i < command[2]; i++) {
                answer = priorityQueue.poll();
            }

            answerList.add(answer);
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
