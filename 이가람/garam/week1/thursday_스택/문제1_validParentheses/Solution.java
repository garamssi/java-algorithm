package garam.week1.thursday_스택.문제1_validParentheses;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("[]{}()"));
    }

    public static Boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> table = new HashMap<>(){
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };

        for(int i=0; i<s.length(); i++) {

            if ( !table.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            } else if( stack.isEmpty() || table.get(s.charAt(i)) != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
