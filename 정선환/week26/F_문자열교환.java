package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1522
 * 문자열 교환
 */
public class F_문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int aCount = 0;
        for (char c : input.toCharArray()) {
            if (c == 'a') {
                aCount++;
            }
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < input.length(); i++) {
            String str;
            if(input.length() - i >= aCount) {
                str = input.substring(i, aCount + i);

            }else {
                String endStr = input.substring(i, input.length());
                String startStr = input.substring(0, aCount - endStr.length());
                str = endStr + startStr;
            }

            int bCount = 0;
            for (char c : str.toCharArray()) {
                if(c == 'b') {
                    bCount++;
                }
            }

            minCount = Math.min(minCount, bCount);
        }

        System.out.println(minCount);
    }
}
