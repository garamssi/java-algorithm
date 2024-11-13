import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 가로
        int m = Integer.parseInt(st.nextToken()); // 세로
        int l = Integer.parseInt(st.nextToken()); // 트램플린 한변의 길이
        int k = Integer.parseInt(st.nextToken()); // 별의 수

        int[][] stars = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = new Main().solution(n, m, l, k , stars);

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private int solution(int n, int m, int l, int k, int[][] stars) {
        int maxCnt = 0;
        for (int[] star1 : stars) {
            for (int[] star2 : stars) {
                int topLeftX = star1[0];
                int topLeftY = star2[1];

                int cnt = calIncludedStarCnt(topLeftX, topLeftY, l, stars);
                maxCnt = Math.max(maxCnt, cnt);
            }
        }

        return k - maxCnt;
    }

    private int calIncludedStarCnt(int topLeftX, int topLeftY, int l, int[][] stars) {
        int bottomRightX = topLeftX + l;
        int bottomRightY = topLeftY + l;

        int cnt = 0;
        for (int[] star : stars) {
            if (star[0] >= topLeftX && star[0] <= bottomRightX &&
                    star[1] >= topLeftY && star[1] <= bottomRightY
            ) {
                cnt++;
            }
        }
        return cnt;
    }
}