package week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11501
 * 주식
 */
public class A_주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            int N = Integer.parseInt(br.readLine());
            long[] prices = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < N; i++) {
                prices[i] = Long.parseLong(st.nextToken());
            }

            long maxPrice = prices[N-1];
            long profit = 0;

            for(int i= N - 2; i >= 0; i--) {
                if(prices[i] > maxPrice) {
                    maxPrice = prices[i];
                } else {
                    profit += maxPrice - prices[i];
                }
            }

            System.out.println(profit);
        }
    }
}
