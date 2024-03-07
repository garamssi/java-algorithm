package week10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class C_다리를지나는트럭 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7,4,5,6}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        // 큐 자료구조 초기화
        Queue<Integer> waitTruckQueue = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++) {
            waitTruckQueue.offer(truck_weights[i]);
        }
        Queue<Integer> crossingTruckQueue = new LinkedList<>();
        Queue<Integer> crossedTruckQueue = new LinkedList<>();

        int time = 0;
        while(!waitTruckQueue.isEmpty() && crossedTruckQueue.size() != truck_weights.length) {
            time++;

            // 대기트럭 -> 다리를 건너는 트럭
            int crossingTruckSum = crossingTruckQueue.stream().mapToInt(Integer::intValue).sum();
            if(crossingTruckQueue.size() < bridge_length && crossingTruckSum < weight) {
                crossingTruckQueue.offer(waitTruckQueue.poll());
            }


        }

        return 0;
    }
}
