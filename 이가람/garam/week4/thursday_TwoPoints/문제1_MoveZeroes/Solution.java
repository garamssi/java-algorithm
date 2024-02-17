package garam.week4.thursday_TwoPoints.문제1_MergeStringsAlternately;

import java.util.*;

/**
 * https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 0만 맨 끝으로 보내기
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
    }

    public static int[] moveZeroes(int[] nums) {

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                queue.addLast(nums[i]);
            } else {
                queue.addFirst(nums[i]);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            nums[index] = queue.removeFirst();
            index++;
        }

        return nums;
    }
}
