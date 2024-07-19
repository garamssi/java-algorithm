package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21921
 * 블로그
 */
public class C_블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] visitors = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int currentSum = 0;
        for (int i = 0; i < x; i++) {
            currentSum += visitors[i];
        }

        int maxSum = currentSum;
        int count = 0;
        for (int i = x; i < n; i++) {
            currentSum = currentSum - visitors[i - x] + visitors[i];
            if(maxSum < currentSum) {
                maxSum = currentSum;
                count = 1;
            }else if(maxSum == currentSum) {
                count++;
            }
        }

        if(maxSum == 0) {
            System.out.println("SAD");
        }else {
            System.out.println(maxSum);
            System.out.println(count);
        }
    }
}
