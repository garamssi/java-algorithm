package week11;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * 이중 우선순위 큐
 */
public class C_이중우선순위큐 {
    public static void main(String[] args) {
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        System.out.println(Arrays.toString(solution(operations)));
    }

    public static int[] solution(String[] operations) {

        PriorityQueue<Integer> ascendingQueue = new PriorityQueue<>(); // 오름차순 큐
        PriorityQueue<Integer> descendingQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순 큐

        for (String operation : operations) {
            String[] element = operation.split(" ");
            String commend = element[0];
            String number = element[1];

            if(commend.equals("I")) {
                ascendingQueue.offer(Integer.parseInt(number));
                descendingQueue.offer(Integer.parseInt(number));

            }
            if(commend.equals("D") && !ascendingQueue.isEmpty() && !descendingQueue.isEmpty()) {
                if(number.equals("-1")) {
                    int minNumber = ascendingQueue.poll();
                    descendingQueue.remove(minNumber);

                }
                if(number.equals("1")) {
                    int maxNumber = descendingQueue.poll();
                    ascendingQueue.remove(maxNumber);
                }
            }
        }

        int[] answer = new int[2];
        if(descendingQueue.peek() != null) {
            answer[0] = descendingQueue.poll();
        }

        if(ascendingQueue.peek() != null) {
            answer[1] = ascendingQueue.poll();
        }

        return answer;
    }
}
