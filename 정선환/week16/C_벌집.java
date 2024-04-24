package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2292
 * 벌집
 */
public class C_벌집 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Integer.parseInt(br.readLine())));
    }

    public static int solution(int num) {
        if(num == 1) {
            return 1;
        }

        int sum = 0;
        for(int i = 1; i < Integer.MAX_VALUE; i++) {
            sum = sum + (6 * i);

            if(num <= sum + 1) {
                return i + 1;
            }
        }

        return 0;
    }

}
