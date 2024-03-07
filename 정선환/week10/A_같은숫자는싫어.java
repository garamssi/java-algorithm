package week10;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java
 * 같은 숫자는 싫어
 */
public class A_같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        solution(arr);
    }

    public static int[] solution(int []arr) {
        Deque<Integer> queue = new ArrayDeque<>();

        for (int num : arr) {
            if(queue.isEmpty() || queue.peekLast() != num) {
                queue.offer(num);
            }
        }

        int[] answer = new int[queue.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }
        return answer;
    }
}
