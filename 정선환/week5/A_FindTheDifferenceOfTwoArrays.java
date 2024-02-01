package week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
 * 2215. Find the Difference of Two Arrays
 */
public class A_FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3};
        int[] num2 = {2, 4, 6, 7};

        System.out.println(findDifference(num1, num2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap();
        for (int num : nums1) {
            map1.put(num, num);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums2) {
            map2.put(num, num);
        }

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> notIncludeList = new ArrayList<>();
        for (Integer key : map1.keySet()) {
            if(!map2.containsKey(key)) {
                notIncludeList.add(key);
            }
        }
        answer.add(notIncludeList);

        notIncludeList = new ArrayList<>();
        for (Integer key : map2.keySet()) {
            if(!map1.containsKey(key)) {
                notIncludeList.add(key);
            }
        }
        answer.add(notIncludeList);

        return answer;
    }

}
