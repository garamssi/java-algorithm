package week11;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * 더 맵게
 */
public class A_더맵게 {

    public static void main(String[] args) {
//        int[] scoville = {1, 2, 3, 9, 10, 12};
//        int[] scoville = {1, 2, 3, 9, 10, 12};
        int[] scoville = {};
        int k = 7;
        System.out.println(solution(scoville, k));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int food : scoville) {
            priorityQueue.offer(food);
        }

        int mixCount = 0;
        List<Integer> foodList = new ArrayList<>();;
        while(priorityQueue.size() >= 2 && priorityQueue.peek() < K) {

            foodList.add(priorityQueue.poll());
            foodList.add(priorityQueue.poll());

            if(foodList.size() == 2) {
                Integer food1 = foodList.get(0);
                Integer food2 = foodList.get(1);

                int mixFood = food1 + food2 * 2;
                priorityQueue.offer(mixFood);
                mixCount++;

                foodList = new ArrayList<>();
            }
        }

        if (!priorityQueue.isEmpty() && priorityQueue.peek() >= K) {
            return mixCount;
        }

        return -1;
    }

}
