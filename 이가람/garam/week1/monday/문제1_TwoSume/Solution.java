package garam.week1.monday.문제1_TwoSume;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(TwoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(TwoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(TwoSum(new int[]{3, 3}, 6)));

    }

    public static int[] TwoSum(int[] nums, int target) {

        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }

            numsMap.put(nums[i], i);
        }

        return null;
    }
}
