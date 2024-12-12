import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[][] answer = new Main().solution(n, heights);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i][0]);
            if (answer[i][0] != 0) {
                sb.append(" ").append(answer[i][1] + 1);
            }

            if (i != n - 1) {
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public int[][] solution(int n, int[] heights) {
        int[][] answer = new int[n][2]; // answer[i][0] = 개수, answer[i][1] = 가장 가까운 탑 번호

        for (int i = 0; i < n; i++) {
            answer[i][1] = -n;
        }

        // 죄측에 보이는 탑
        Deque<Tower> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek().height <= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer[i][0] = 0;
            } else {
                answer[i][0] = stack.size();
                answer[i][1] = stack.peek().idx;
            }

            stack.push(new Tower(i, heights[i]));
        }


        stack.clear();
        // 우측에 보이는 탑
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().height <= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i][0] += stack.size();

                // i번째 건물에서 거리가 가장 가까운 건물의 번호 중 작은 번호로 업데이트
                if (Math.abs(i - stack.peek().idx) < Math.abs(i - answer[i][1])) {
                    answer[i][1] = stack.peek().idx;
                } else if (i - stack.peek().idx == i - answer[i][1]) {
                    answer[i][1] = Math.min(stack.peek().idx, answer[i][1]);
                }
            }

            stack.push(new Tower(i, heights[i]));
        }
        return answer;
    }

    static class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}