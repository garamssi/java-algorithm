import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String bolls = br.readLine();

        int result = new Main().solution(n, bolls);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    private int solution(int n, String bolls) {
        int rCnt = 0;
        int bCnt = 0;
        int ans = n;

        for (int i = 0; i < n; i++) {
            if (bolls.charAt(i) == 'R') {
                rCnt++;
            } else {
                bCnt++;
            }
        }

        // R을 모두 왼쪽으로
        // seq = 왼쪽의 연속된 R의 개수
        int seq = 0;
        for (int i = 0; i < n; i++) {
            if (bolls.charAt(i) == 'R') {
                seq++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, rCnt - seq);

        // R을 모두 오른쪽으로
        // seq = 오른쪽의 연속된 R의 개수
        seq = 0;
        for (int i = n - 1; i > 0; i--) {
            if (bolls.charAt(i) == 'R') {
                seq++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, rCnt - seq);


        // B을 모두 왼쪽으로
        // seq = 왼쪽의 연속된 B의 개수
        seq = 0;
        for (int i = 0; i < n; i++) {
            if (bolls.charAt(i) == 'B') {
                seq++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, bCnt - seq);

        // B을 모두 오른쪽으로
        // seq = 오른쪽의 연속된 B의 개수
        seq = 0;
        for (int i = n - 1; i > 0; i--) {
            if (bolls.charAt(i) == 'B') {
                seq++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, bCnt - seq);

        return ans;
    }
}