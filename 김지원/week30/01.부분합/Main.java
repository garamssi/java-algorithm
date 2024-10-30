import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int result = new Main().solution(n, s, nums);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    public int solution(int n, int s, int[] nums) {
        int left = 0, right = 0, sum = 0;

        int answer = Integer.MAX_VALUE;
        while (true) {
            if (sum >= s) {
                sum -= nums[left];
                left++;
            } else if (right == n) { // sum < M
                break;
            } else { // sum < M && right != n
                sum += nums[right];
                right++;
            }

            if (sum >= s) {
                // (left, right-1)의 길이
                answer = Math.min(right - left, answer);
            }
        }

        return answer != Integer.MAX_VALUE ? answer : 0;
    }
}