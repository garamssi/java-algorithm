package garam.week8.thursday_Heap_PriorityQueue.문제3_TotalCostToHireKWorkers;


import java.util.*;

/**
 * https://leetcode.com/problems/total-cost-to-hire-k-workers/?envType=study-plan-v2&envId=leetcode-75
 *
 *
 */

public class Solution {
    public static void main(String[] args) {

        System.out.println(totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));

    }

    public static long totalCost(int[] costs, int k, int candidates) {
        // 왼쪽, 오른쪽의 인덱스 지정
        int left = 0;
        int right = costs.length - 1;

        PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

        long totalCost = 0;

        while (k-- > 0) {
            // candidates보다 큐의 후보가 적어지면 겹치지 않는 선에서 후보 채워주기
            while (leftQueue.size() < candidates && left <= right) {
                leftQueue.offer(costs[left++]);
            }
            // candidates보다 큐의 후보가 적어지면 겹치지 않는 선에서 후보 채워주기
            while (rightQueue.size() < candidates && left <= right) {
                rightQueue.offer(costs[right--]);
            }

            // 큐에 값이 있다면 삭제하지 않고 하나 꺼내오고, 큐에 값이 비어있다면 MAX 값 부여
            int leftCost = leftQueue.size() > 0 ? leftQueue.peek() : Integer.MAX_VALUE;
            int rightCost = rightQueue.size() > 0 ? rightQueue.peek() : Integer.MAX_VALUE;

            // 양쪽의 큐값을 비교해서 작은 값으로 totalCost 에 더하기
            if (leftCost <= rightCost) {
                totalCost += leftCost;
                leftQueue.poll();
            } else {
                totalCost += rightCost;
                rightQueue.poll();
            }
        }

        return totalCost;
    }
}
