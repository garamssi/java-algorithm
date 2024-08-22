import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int result = new Main().solution(str);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    // 슬라이딩 윈도우
    // a 개수 만큼의 윈도우 크기에 b 개수가 최소인 경우
    // b 개수 만큼 교환을 한다.
    private int solution(String str) {
        int aCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                aCnt++;
            }
        }

        int bCnt = 0;
        for (int i = 0; i < aCnt; i++) {
            if (str.charAt(i) == 'b') {
                bCnt++;
            }
        }

        int ans = bCnt;
        int left = 0, right = aCnt - 1;

        while (left < str.length()) {
            if (str.charAt(++right % str.length()) == 'b') bCnt++;
            if (str.charAt(left++) == 'b') bCnt--;

            ans = Math.min(ans, bCnt);
        }

        return ans;
    }
}