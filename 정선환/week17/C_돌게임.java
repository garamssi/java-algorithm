package week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9655
 * 돌 게임
 */
public class C_돌게임 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            System.out.println(solution(n));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String solution(int n) {
        return n % 2 == 0 ? "CY" : "SK";
    }
}
