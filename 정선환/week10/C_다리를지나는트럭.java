package week10;

import java.util.LinkedList;
import java.util.Queue;

public class C_다리를지나는트럭 {
    public static void main(String[] args) {
//        System.out.println(solution(2, 10, new int[]{7,4,5,6}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // 큐 자료구조 초기화
        Queue<Integer> waitTruckQueue = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++) {
            waitTruckQueue.offer(truck_weights[i]);
        }

        Queue<Integer> bridgeQueue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(0);
        }

        int time = 0;
        int currentBridgeWeight = 0;

        while(!bridgeQueue.isEmpty()) {
            time++;

            // 다리를 건너는 트럭 -> 다리를 지난 트럭
            int crossingTruck = bridgeQueue.poll();
            currentBridgeWeight -= crossingTruck;

            // 대기트럭 -> 다리를 건너는 트럭
            if(!waitTruckQueue.isEmpty()) {
                if(currentBridgeWeight + waitTruckQueue.peek() <= weight) {
                    int truck = waitTruckQueue.poll();
                    bridgeQueue.offer(truck);
                    currentBridgeWeight += truck;
                }else {
                    bridgeQueue.offer(0);
                }
            }
        }

        return time;
    }

}
