package week10;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586?language=java
 * 기능개발
 */
public class B_기능개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(solution(progresses, speeds));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;
        Queue<Integer> daysQueue = new LinkedList<>();

        // 배포 남은 일 수 구하기
        for (int i = 0; i < length; i++) {
            int remainProgress = 100 - progresses[i];
            if (remainProgress % speeds[i] == 0) {
                daysQueue.offer(remainProgress / speeds[i]);
            } else {
                daysQueue.offer(remainProgress / speeds[i] + 1);
            }
        }

        // 배포 작업 카운팅
        List<Integer> deployCountList = new ArrayList<>();
        while (!daysQueue.isEmpty()) {
            int deployCount = 1;
            int temp = daysQueue.poll();

            while(!daysQueue.isEmpty() && temp >= daysQueue.peek()) {
                deployCount++;
                daysQueue.poll();
            }

            deployCountList.add(deployCount);
        }


        // 정답
        int[] answer = new int[deployCountList.size()];
        for (int i = 0; i < deployCountList.size(); i++) {
            answer[i] = deployCountList.get(i);
        }
        return answer;
    }
}
