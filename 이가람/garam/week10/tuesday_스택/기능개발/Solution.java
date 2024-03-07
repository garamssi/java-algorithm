package garam.week10.tuesday_스택.기능개발;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * 기능개발
 *
 *
 */

public class Solution {

    public static void main(String[] args) {
//        solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});

        solution(new int[]{95, 90, 99, 99, 80, 9}, new int[]{1, 1, 1, 1, 1, 1});
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> progressQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            // 각 기능이 완성되는데 필요한 날짜를 계산
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            // 큐가 비어있지 않고, 현재 기능이 이전 기능보다 늦게 완성되면
            // 이전 기능과 함께 배포
            if (!progressQueue.isEmpty() && progressQueue.peek() < day) {
                answerList.add(progressQueue.size());
                progressQueue.clear();
            }
            progressQueue.offer(day);
        }

        // 마지막 배포가 있을 수 있으므로 큐가 비어있지 않다면 남은 기능도 배포
        if (!progressQueue.isEmpty()) {
            answerList.add(progressQueue.size());
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }

}
