package week5;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75
 * 1657. Determine if Two Strings Are Close
 */
public class C_DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "bcad";
        closeStrings(word1, word2);
    }

    public static boolean closeStrings(String word1, String word2) {
        // Operation1
        System.out.println(operation1(word1, word2));
        System.out.println(operation2(word1, word2));

        return operation1(word1, word2) && operation2(word1, word2);
    }

    public static boolean operation1(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
            if(map1.getOrDefault(c, 0).intValue() != map2.getOrDefault(c, 0).intValue()) {
                return false;
            }
        }

        return true;
    }

    public static boolean operation2(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        return false;
    }
}
