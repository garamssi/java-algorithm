import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truckWeights = new LinkedList<>();
        for (int tw : truck_weights) {
            truckWeights.offer(tw);
        }
        
        // 트럭이 없는 위치는 0으로 초기화
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int totalTime = 0;
        int currentBridgeWeight = 0;

        while (!bridge.isEmpty()) {
            int outTruck = bridge.poll();
            currentBridgeWeight -= outTruck;
            totalTime += 1;
            if (!truckWeights.isEmpty()) {
                // 트럭이 다리위에 올라갈수 있다면
                if (currentBridgeWeight + truckWeights.peek() <= weight) {
                    int truckWeight = truckWeights.poll();
                    currentBridgeWeight += truckWeight;
                    bridge.offer(truckWeight);
                } else {
                    bridge.offer(0);
                }
            }
        }
        return totalTime;
    }
}