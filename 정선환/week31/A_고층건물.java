package week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1027
 * 고층 건물
 */
public class A_고층건물 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        if(N == 1) {
            System.out.println(0);
            return;
        }

        int[] buildings = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int maxVisibleCount = 0;
        for (int i = 1; i < buildings.length; i++) {
            int visibleCount = 0;

            // 왼쪽 건물 탐색
            double leftInclination = Double.NEGATIVE_INFINITY;
            for (int j = i - 1; j >= 1; j--) {
//                double inclination = getInclination(buildings[i], buildings[j], i - j);
                double inclination = getInclination(buildings[j], buildings[i], i - j);
                if (inclination > leftInclination) {
                    leftInclination = inclination;
                    visibleCount++;
                }
            }

            // 오른쪽 건물 탐색
            double rightInclination = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < N; j++) {
                double inclination = getInclination(buildings[j], buildings[i], j - i);
                if (inclination > rightInclination) {
                    rightInclination = inclination;
                    visibleCount++;
                }
            }

            maxVisibleCount = Math.max(maxVisibleCount, visibleCount);
        }

        System.out.println(maxVisibleCount);
    }

    // 건물 A와 건물 B를 이은 선분의 기울기  = 건물 A의 높이 - 건물 B의 높이 / 건물 A와 B의 거리
    static double getInclination(int heightA, int heightB, int distanceAB) {
        return (double) (heightA - heightB) / distanceAB;
    }
}
