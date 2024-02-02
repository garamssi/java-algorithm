package week5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * 2390. Removing Stars From a String
 */
public class D_RemovingStarsFromAString {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    public static String removeStars(String s) {
         Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if(c == '*') {
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }

}
