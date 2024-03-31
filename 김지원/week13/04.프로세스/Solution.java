import java.util.Collections;
import java.util.PriorityQueue;

// priorities = [1, 1, 9, 1, 1, 1]
// pq = [9, 1, 1, 1, 1, 1]

class Solution {
    public int solution(int[] priorities, int location) {
        int order = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : priorities) {
            pq.add(num);
        }
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (!pq.isEmpty() && pq.peek() == priorities[i]) {
                    pq.poll();
                    order++;
                    if (i == location) {
                        return order;
                    }
                }
            }
        }
        return order;
    }
}