import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int result = new Main().solution(n, k, nums);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    private int solution(int n, int k, int[] nums) {
        if (n == 1) {
            return 1;
        }

        int[] cnt = new int[100_001];
        int left = 0;
        int right = 0;
        int len = 0;

        while (right < nums.length) {
            if (cnt[nums[right]] < k) {
                cnt[nums[right]]++;
                right++;
            } else {
                cnt[nums[left]]--;
                left++;
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}