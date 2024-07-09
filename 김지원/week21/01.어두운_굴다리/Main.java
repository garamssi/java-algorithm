import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /*
    입력값
    5
    2
    2 4
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main t = new Main();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = t.solution(n, m, arr);

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public int solution(int bridgeLen, int numLight, int[] lightPos) {
        int min = lightPos[0];
        int max = bridgeLen;
        int mid = 0;
        int answer = 0;


        // while 문
        // min = 0, max = 5
        // mid = 2

        // min = 0, max = 1
        // mid = 0

        // min = 1, max = 1
        // mid = 1
        
        while (min <= max) {
            mid = (min + max) / 2;
            if (isBright(bridgeLen, mid, numLight, lightPos)) {
                // 다 비춰지면
                answer = mid;
                max = mid - 1;
            } else {
                // 안 비춰지면
                min = mid + 1;
            }
        }

        return answer;
    }

    private boolean isBright(int bridgeLen, int lightLen, int numLight, int[] lightPos) {
        int currentEnd = 0;  // 각 가로등이 빛이 어느정도 비춰졌냐... 

        for (int i = 0; i < numLight; i++) {
            if (lightPos[i] - lightLen > currentEnd) {
                // 현재 조명의 시작점이 이전 조명의 끝점을 넘으면 다리가 비추지 않음
                return false;
            }
            currentEnd = lightPos[i] + lightLen;
        }

        return currentEnd >= bridgeLen;
    }
}