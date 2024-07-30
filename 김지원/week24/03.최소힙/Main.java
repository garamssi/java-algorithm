import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        String result = new Main().solution(nums);

        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }

    private String solution(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> prorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            if (num != 0) {
                prorityQueue.offer(num);
            } else {
                if (!prorityQueue.isEmpty()) {
                    sb.append(prorityQueue.poll()).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
        }
        return sb.toString();
    }
}