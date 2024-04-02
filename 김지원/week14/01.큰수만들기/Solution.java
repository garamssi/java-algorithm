import java.util.Stack;

class Solution {

    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        int removeCnt = 0;
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            while (!stack.isEmpty() && removeCnt < k && stack.peek() < digit) {
                stack.pop();
                removeCnt++;
            }
            stack.push(digit);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().substring(0, number.length() - k);
    }

    // 시간복잡도: O(n^2) => 시간초과
    public String solution2(String number, int k) {
        int len = number.length() - k;
        StringBuilder answer = new StringBuilder();

        int start = 0;
        for (int i = 0; i < len; i++) {
            int max = 0;
            int maxIdx = 0;
            for (int j = start; j <= k + i; j++) {
                int num = number.charAt(j) - '0';
                if (num > max) {
                    max = num;
                    maxIdx = j;
                    start = maxIdx + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}

