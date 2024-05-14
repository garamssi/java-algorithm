package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10431
 * 줄 세우기
 */
public class A_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        while(count-- > 0) {
            String line = br.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            String number = stringTokenizer.nextToken();

            int[] arr = new int[20];
            for(int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            System.out.println(number + " " + solution(arr));

        }

    }

    public static int solution(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] < arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
