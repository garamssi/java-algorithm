package garam.week8.tuesday_암시적BFS.문제3_KthLargestElementinanArray_우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=leetcode-75
 * k번째 가장 큰 요소 리턴하기.
 */
public class Solution {

    public static void main(String[] args) {

        /**
         * 예시 1:
         *
         * 입력: nums = [3,2,1,5,6,4], k = 2
         *  출력: 5
         * 예 2:
         *
         * 입력: nums = [3,2,3,1,2,4,5,5,6], k = 4
         *  출력: 4
         */

        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));

    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        int index = 1;

//        [3,2,1,5,6,4]
//        [6, 5, 4, 3, 2 ,1]
//        k = 2
        while (!queue.isEmpty()) {
            if(index == k) {
                return queue.poll();
            }

            queue.poll();
            index++;
        }

        return -1;
    }
}
