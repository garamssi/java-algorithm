import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n; // 1 ~ n 층 이동
    static int k; // 자리 수
    static int p; // 반전 할 수 있는 작대기 수
    static int x; // 현재 층
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        new Main().solution();

        bw.write(String.valueOf(cnt));
        br.close();
        bw.flush();
        bw.close();
    }

    /*
    - 0 ~ 9 까지 1, 0 로 표현
    - 맨위 0, 중간 3, 맨 아래 6, 나머지: 왼쪽위 -> 오른쪽아래로 발번
            |￣|
            |￣|
             ￣
    - k 자리로 만들 수 있는 모든 수 탐색
    - 탐색 한 수와 현재 수(x)를 비교하여 몇개의 반전이 일어난지 확인
     */

    private void solution() {
        int[] nums = new int[10];
        nums[0] = Integer.parseInt("1110111", 2);
        nums[1] = Integer.parseInt("100100", 2);
        nums[2] = Integer.parseInt("1011101", 2);
        nums[3] = Integer.parseInt("1101101", 2);
        nums[4] = Integer.parseInt("101110", 2);
        nums[5] = Integer.parseInt("1101011", 2);
        nums[6] = Integer.parseInt("1111011", 2);
        nums[7] = Integer.parseInt("100101", 2);
        nums[8] = Integer.parseInt("1111111", 2);
        nums[9] = Integer.parseInt("1101111", 2);

        int[] curFloor = new int[k];
        Arrays.fill(curFloor, nums[0]); // k > 2 일때 x 가 한자리수인 경우 -> 나머지를 0으로 채운다.
        int idx = k - 1;
        int tempX = x;
        while (tempX != 0) {
            curFloor[idx] = nums[tempX % 10];
            tempX /= 10;
            idx--;
        }

        dfs(curFloor, 0, 0, 0, nums);
    }

    private void dfs(int[] curFloor, int changedFloor, int idx, int pCnt, int[] nums) {
        if (changedFloor > n) {
            return;
        }

        if (idx == curFloor.length) {
            if (pCnt <= p && pCnt != 0
                    && changedFloor > 0) {
                cnt++;
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            dfs(curFloor, changedFloor * 10 + i, idx + 1, pCnt + calReverseCnt(curFloor[idx], nums[i]), nums);
        }
    }

    private int calReverseCnt(int num, int target) {
        int reverse = num ^ target;
        int cnt = 0;

        while (reverse > 0) {
            cnt += (reverse & 1); // 마지막 비트가 1인지 확인
            reverse >>= 1; // 오른쪽으로 1비트 이동
        }

        return cnt;
    }
}