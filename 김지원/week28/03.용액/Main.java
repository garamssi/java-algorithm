import java.io.*;
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

        String result = new Main().solution(n, nums);

        bw.write(result);
        br.close();
        bw.flush();
        bw.close();
    }

    private String solution(int n, int[] nums) {
        int left = 0;
        int right = n - 1;

        int n1 = 0, n2 = 0;
        int min = Integer.MAX_VALUE;

        while (left < right) {
            int mix = nums[left] + nums[right];
            if (Math.abs(mix) < min) {
                n1 = nums[left];
                n2 = nums[right];
                min = Math.abs(mix);
            }

            // 두 용액의 합이 0에 가까이 되도록 포인터(left,right)를 이동한다.
            if (mix <= 0) {
                left++; // 작은 값을 크게
            } else {
                right--; // 큰 값을 작게
            }
        }

        return n1 + " " + n2;
    }
}