package week1;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * 더 맵게
 */
public class I_MoreSpicy {
    public static void main(String[] args) {
        int[] foods = {1, 2, 3, 9, 10, 12};
        int k = 7;

        System.out.println(moreSpicy(foods, k));
    }

    public static int moreSpicy(int[] scoville, int K) {
        int answer = 0;

        // 우선순위 큐로 정렬
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int food : scoville) {
            priorityQueue.offer(food);
        }

        while(priorityQueue.size() >= 2 && priorityQueue.peek() < K) {
            mixFood(priorityQueue);
            answer ++;
        }

        if (!priorityQueue.isEmpty() && priorityQueue.peek() >= K) {
            return answer;
        }

        return -1;
    }

    public static void mixFood(PriorityQueue<Integer> priorityQueue) {
        int firstFood = priorityQueue.poll();
        int secondFood = priorityQueue.poll();
        int mixFood = firstFood + (secondFood * 2);
        priorityQueue.offer(mixFood);
    }

}
