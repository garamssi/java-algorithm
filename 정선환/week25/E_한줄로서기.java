package week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1138
 * 한 줄로 서기
 */
public class E_한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int tallCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
                if (tallCount == 0 && line[j] == 0) {
                    line[j] = i + 1;
                    break;
                } else if (line[j] == 0) {
                    tallCount--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(line[i] + " ");
        }
    }
}
