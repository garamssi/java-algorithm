import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        int result = new Main().solution(house, n, m);
        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    private int solution(int[] house, int n, int wifiCnt) {
        Arrays.sort(house);

        int left = 0;
        int right = house[n - 1];

        int maxDistance = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (getInstallableWiFiCnt(house, mid) >= wifiCnt) {
                maxDistance = Math.max(mid, maxDistance);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxDistance;
    }

    private int getInstallableWiFiCnt(int[] house, int distance) {
        int pre = 0;
        int cnt = 1;

        for (int i = 1; i < house.length; i++) {
            if (house[i] - house[pre] >= distance) {
                cnt++;
                pre = i;
            }
        }

        return cnt;
    }
}
