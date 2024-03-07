import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int rest = 100 - progresses[i];

            int days;
            if (rest % speeds[i] == 0) {
                days = rest / speeds[i];
            } else {
                days = rest / speeds[i] + 1;
            }
            q.offer(days);
        }

        List<Integer> answer = new ArrayList<>();

        int bound = q.peek();
        int cnt = 0;
        while (!q.isEmpty()) {
            if (bound >= q.peek()) {
                cnt++;
                q.poll();
            } else {
                answer.add(cnt);
                cnt = 0;
                bound = q.peek();
            }
        }
        answer.add(cnt);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}