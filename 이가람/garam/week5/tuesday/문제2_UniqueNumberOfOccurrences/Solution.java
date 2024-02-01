package garam.week5.tuesday.문제2_UniqueNumberOfOccurrences;

import java.util.*;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75
 *
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();

            if(!countMap.containsKey(value)){
                countMap.put(value, 1);
            }
            else {
                return false;
            }
        }


        return true;
    }
}
