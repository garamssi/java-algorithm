package garam.week4.thursday.문제1_MergeStringsAlternately;

import java.util.*;

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
