import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        String word = "";
        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                // 문자 추출
                while (!stack.isEmpty() && !Character.isDigit(stack.peek())) {
                    if (stack.peek() != '[') {
                        word = stack.pop() + word;
                    } else {
                        stack.pop();
                    }
                }
                
                // 숫자 추출
                String digits = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    digits = stack.pop() + digits;
                }
                int digit = Integer.parseInt(digits);
                for (int i = 0; i < digit; i++) {
                    for (char wch : word.toCharArray()) {
                        stack.push(wch);
                    }
                }
                word = "";
            } else {
                // 숫자, 문자, [ 이 나올때
                stack.push(ch);
            }
        }

        String answer = "";
        while (!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }
        return answer;
    }
}