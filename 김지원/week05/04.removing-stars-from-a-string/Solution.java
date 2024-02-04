import java.util.*;

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
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