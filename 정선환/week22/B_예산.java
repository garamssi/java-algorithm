package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/2512
 * 예산
 */
public class B_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] regions = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int budget = Integer.parseInt(bf.readLine());

        // 예산 이하일 경우,
        if(!isOver(regions, budget)) {
            System.out.println(regions[n - 1]);
            return ;
        }

        int mid = (regions[0] + regions[n - 1]) / 2;

        int overIndex = -1;
        for (int i = 0; i < n; i++) {
            if(mid < regions[i]) {
                overIndex = i;
                break;
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = regions[i];
        }

        while(isOver(answer, budget)) {
            mid--;
            for (int i = overIndex; i < n; i++) {
                answer[i] = mid;
            }
        }

        System.out.println(answer[n - 1]);
    }

    private static boolean isOver(int[] regions, int budget) {
        int total = Arrays.stream(regions).sum();
        return total > budget;
    }
}
