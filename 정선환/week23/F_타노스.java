package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/20310
 * 타노스
 */
public class F_타노스 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();

        int zeroCount = 0;
        int oneCount = 0;
        for (char c : line.toCharArray()) {
            if(c == '0') {
                zeroCount++;
            }else {
                oneCount++;
            }
        }

        zeroCount /= 2;
        oneCount /= 2;

        char[] str = line.toCharArray();

        for (int i = 0; i < str.length; i++) {
            if (oneCount > 0 && str[i] == '1') {
                str[i] = ' ';
                oneCount--;
            }

            if (oneCount == 0) {
                break;
            }
        }

        for (int i = str.length - 1; i >= 0; i--) {
            if (zeroCount > 0 && str[i] == '0') {
                str[i] = ' ';
                zeroCount--;
            }

            if (zeroCount == 0) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : str) {
            if (ch != ' ') {
                sb.append(ch);
            }
        }

        System.out.println(sb.toString());


    }
}
// 10010011
//
