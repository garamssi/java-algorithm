package week5;

import java.util.*;

/**
 * https://leetcode.com/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75
 * 649. Dota2 Senate
 */
public class H_Dota2Senate {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }


    public static String predictPartyVictory(String senate) {
        int length = senate.toCharArray().length;

        Deque<Character> stack = new ArrayDeque<>();
        int rCount = 0;
        int dCount = 0;
        for (char c : senate.toCharArray()) {
            if(c == 'R') {
                if(stack.isEmpty() || stack.peek() == 'R') {
                    rCount = rCount + 2;
                }else {
                    rCount = rCount + 1;
                }
            }else {
                if(stack.isEmpty() || stack.peek() == 'D') {
                    dCount = dCount + 2;
                }else {
                    dCount = dCount + 1;
                }
            }

            stack.push(c);
        }

        if(rCount > dCount) {
            return "Radiant";
        }else if(rCount < dCount) {
            return "Dire";
        }else {
            return senate.charAt(length - 1) == 'R' ? "Radiant" : "Dire";
        }
    }
}
