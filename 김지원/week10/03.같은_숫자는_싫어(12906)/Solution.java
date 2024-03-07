import java.util.Stack;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (!stack.isEmpty() && stack.peek() == num) {
                continue;
            }
            stack.push(num);
        }
        int stackSize = stack.size();
        int[] answer = new int[stackSize];
        for (int i = 0; i < stackSize; i++) {
            answer[stackSize - 1 - i] = stack.pop();
        }

        return answer;
    }
}