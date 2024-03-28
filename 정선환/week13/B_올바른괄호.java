package week13;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * 올바른 괄호
 */
public class B_올바른괄호 {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution("(()()("));
    }

    static boolean solution(String s) {

        char[] parentheses = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char parenthesis : parentheses) {
            if(parenthesis == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(parenthesis);
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
