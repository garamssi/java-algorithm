package week23;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/19941
 * 햄버거 분배
 */
public class B_햄버거분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = bf.readLine().split(" ");
        String n = input1[0];
        String k = input1[1];
        String input2 = bf.readLine();

        char[] chairs = input2.toCharArray();
        boolean[] ateArray = new boolean[chairs.length];

        int atePersonCount = 0;
        for (int i = 0; i < chairs.length; i++) {
            if(chairs[i] == 'P') {
                if(isEat(chairs, i, Integer.parseInt(k), ateArray)) {
                    atePersonCount++;
                }
            }
        }

        System.out.println(atePersonCount);

    }

    private static boolean isEat(char[] chairs, int i, int k, boolean[] eatFlagArray) {
        int start = i - k;
        if(start < 0) {
            start = 0;
        }
        // start = Math.max(start, 0); // 한줄로 표현

        int end = i + k;
        if(end >= chairs.length) {
            end = chairs.length - 1;
        }
        for (int j = start; j <= end; j++) {
            if(chairs[j] == 'H' && !eatFlagArray[j]) {
                eatFlagArray[j] = true;
                return true;
            }
        }
        return false;
    }
}
