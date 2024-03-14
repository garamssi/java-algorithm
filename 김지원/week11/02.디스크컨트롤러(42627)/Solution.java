import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int rs = new Solution().solution(jobs);
        System.out.println(rs);
    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (Comparator.comparingInt(o -> o[0])));
        Queue<int[]> wait = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int count = 0; // 처리한 작업 수
        int last = -1; // 최근 작업이 끝난 시간
        int time = jobs[0][0]; // 총 작업시간
        int len = jobs.length;
        int answer = 0;

        while (count < len) {
            for (int[] job : jobs) {
                if (last < job[0] && job[0] <= time) {
                    wait.offer(job);
                }
            }
            // 바로 수행할 수 있는 작업이 있는 경우
            if (!wait.isEmpty()) {
                last = time;
                int[] job = wait.poll();
                count++;
                time += job[1];
                answer += time - job[0];
            } else { // 바로 수행할 수 있는 작업이 없는 경우
                time += 1;
            }
        }
        return answer / len;
    }
}