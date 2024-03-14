import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (String operation : operations) {
            String[] op = operation.split(" ");
            if (Objects.equals(op[0], "I")) {
                Integer number = Integer.valueOf(op[1]);
                maxHeap.add(number);
                minHeap.add(number);
            } else if (Objects.equals(op[1], "1")) {
                if (!maxHeap.isEmpty()) {
                    Integer out = maxHeap.poll();
                    minHeap.remove(out);
                }
            } else {
                if (!minHeap.isEmpty()) {
                    Integer out = minHeap.poll();
                    maxHeap.remove(out);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = maxHeap.isEmpty() ? 0 : maxHeap.peek();
        answer[1] = minHeap.isEmpty() ? 0 : minHeap.peek();
        return answer;
    }
}