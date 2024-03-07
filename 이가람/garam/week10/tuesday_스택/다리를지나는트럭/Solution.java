package garam.week10.tuesday_스택.다리를지나는트럭;

import java.util.*;


/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 *
 * Queue에는 다리에 있는 트럭의 무게가 순차적으로 기록되며,
 * currentWeight 변수를 사용하여 현재 다리에 있는 트럭의 총 무게를 관리합니다.
 * 다리에 새 트럭이 진입할 수 있는지 확인하고, 진입할 수 없다면 다리의 길이만큼 0을 채워 넣어 시간을 기록합니다.
 * 모든 트럭이 진입한 후에는 다리 길이만큼의 시간을 추가하여 트럭이 완전히 건너는 시간을 계산합니다.
 */
public class Solution {
    public static void main(String[] args) {

        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
//        System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));

    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {

        // 다리를 건너는 트럭들의 무게를 관리할 큐
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0; // 전체 소요 시간
        int currentWeight = 0; // 현재 다리 위에 있는 트럭들의 무게 합

        // 모든 트럭에 대해 반복
        for (int truckWeight : truck_weights) {
            // 트럭이 다리를 건널 수 있을 때까지 반복
            while (true) {
                // 다리가 비어있는 경우
                if (bridge.isEmpty()) {
                    // 트럭을 다리에 올림
                    bridge.offer(truckWeight);
                    // 현재 무게에 트럭 무게를 추가
                    currentWeight += truckWeight;
                    // 시간을 증가시킴
                    time++;
                    // 다음 트럭으로 넘어감
                    break;

                // 다리의 크기가 최대 길이에 도달한 경우 (트럭이 더 이상 올라갈 수 없음)
                } else if (bridge.size() == bridge_length) {

                    // 다리에서 트럭을 내림 (가장 먼저 올라간 트럭)
                    currentWeight -= bridge.poll();

                // 다리에 아직 공간이 있는 경우
                } else {
                    // 새로운 트럭을 올릴 수 있는지 확인 (무게 제한 체크)
                    if (currentWeight + truckWeight <= weight) {
                        // 다리에 트럭을 올림
                        bridge.offer(truckWeight);
                        // 현재 무게에 트럭 무게를 추가
                        currentWeight += truckWeight;
                        // 시간을 증가시킴
                        time++;
                        // 다음 트럭으로 넘어감
                        break;
                    } else {
                        // 다리에 트럭을 올릴 수 없다면, 다리의 트럭 순서를 유지하기 위해 0을 삽입
                        bridge.offer(0);
                        // 시간을 증가시킴
                        time++;
                    }
                }
            }
        }

        // 모든 트럭이 다리에 올라간 후, 마지막 트럭이 내릴 때까지의 시간을 더해줌
        return time + bridge_length;
    }


}
