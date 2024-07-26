package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1515
 * 수 이어 쓰기
 */
public class A_수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();

        int n = 0;
        int index = 0;

        while(true) {
            n++;
            for (char nSeparate : String.valueOf(n).toCharArray()) {
                if(nSeparate == line.charAt(index)) {
                    index++;

                    if(index >= line.length()) {
                        System.out.println(n);
                        return;
                    }
                }
            }


        }
    }
}
