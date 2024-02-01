package garam.week5.tuesday.문제1_FindTheDifferenceOfTwoArrays;

import java.util.*;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // {1, 2, 3}
        for (int num : nums1) {
            set1.add(num);
        }

        // {2, 4, 6}
        for (int num : nums2) {
            set2.add(num);
        }

        Set<Integer> diffSet1 = new HashSet<>(set1);

        // {2} 지워짐 -> {1, 3}
        diffSet1.removeAll(set2);

        // {2, 4, 6}
        Set<Integer> diffSet2 = new HashSet<>(set2);

        // {4, 6}
        diffSet2.removeAll(set1);

        List<Integer> result1 = new ArrayList<>(diffSet1);
        List<Integer> result2 = new ArrayList<>(diffSet2);

        List<List<Integer>> result = new ArrayList<>();
        result.add(result1);
        result.add(result2);

        return result;
    }
}
