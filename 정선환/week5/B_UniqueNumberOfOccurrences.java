package week5;

import java.util.*;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
 * 1207. Unique Number of Occurrences
 */
public class B_UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        System.out.println(map);

        Set<Integer> set = new HashSet();
        for (int i : map.keySet()) {
            Integer value = map.get(i);
            if(set.contains(value)) {
                return false;
            }
            set.add(value);
        }
        return true;
    }

}
