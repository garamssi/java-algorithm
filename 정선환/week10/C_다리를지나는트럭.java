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
        Queue<Truck> waitTruckQueue = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++) {
            Truck truck = new Truck(i, truck_weights[i]);
            waitTruckQueue.offer(truck);
        }
        Queue<Truck> crossingTruckQueue = new LinkedList<>();
        Queue<Truck> crossedTruckQueue = new LinkedList<>();

        // 트럭 이동 중인 map
        Map<Truck, Integer> crossingTruckMap = new HashMap<>();

        int time = 0;
        while(!waitTruckQueue.isEmpty() && crossedTruckQueue.size() != truck_weights.length) {
            time++;

            // 다리를 건너는 트럭 -> 다리를 지난 트럭


            // 대기트럭 -> 다리를 건너는 트럭
            int crossingTruckSum = crossingTruckQueue.stream().mapToInt(Truck::getWeight).sum();
            if(crossingTruckQueue.size() < bridge_length && crossingTruckSum < weight) {
                Truck truck = waitTruckQueue.poll();
                crossingTruckQueue.offer(truck);
                crossingTruckMap.put(truck, 1);
            }


        }

        return 0;
    }

    public static class Truck {
        int number;
        int weight;

        public Truck(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }

        public int getNumber() {
            return number;
        }

        public int getWeight() {
            return weight;
        }
    }

}
