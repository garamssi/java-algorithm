package week1;

import java.util.Scanner;
import java.util.Stack;

/**
 * Valid Parentheses (유효한 괄호)
 *
 * 대중소 세류 괄호로 된 입력값이 유효한지 판별하라
 * 입력: []{}()
 * 출력: true
 *
 * https://leetcode.com/problems/valid-parentheses/
 */
public class E_ValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        isValid(input);
    }

    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : charArray) {
            if(c == '(') {
                stack.push(')');

            }else if(c == '{') {
                stack.push('}');

            }else if(c == '[') {
                stack.push(']');

            }else {
                if(stack.isEmpty() || c != stack.pop().charValue()) {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        }

        return false;
    }
}
