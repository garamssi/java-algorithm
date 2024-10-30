import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long result = new Main().solution(n, nums);
        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    private long solution(int n, int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        boolean[] used = new boolean[maxNum + 1];
        int start = 0;
        int end = 0;
        long answer = 0;

        while (end < n) {
            if (!used[nums[end]]) {
                used[nums[end]] = true;
                answer += end - start + 1;
                end += 1;
            } else {
                used[nums[start]] = false;
                start += 1;
            }
        }
        
        return answer;
    }
}
