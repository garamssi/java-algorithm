package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/23971
 * ZOAC 4
 */
public class A_Zoac4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = solution(h, w, n, m);

        System.out.println(result);
    }

    public static int solution(int h, int w, int n, int m) {
        int sitX = w / (m + 1);
        if(w % (m + 1) != 0) {
            sitX++;
        }

        int sitY = h / (n + 1);
        if(h % (n + 1) != 0) {
            sitY++;
        }

        return sitX * sitY;
    }

}
