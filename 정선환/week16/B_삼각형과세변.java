package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5073
 * 삼각형과 세변
 */
public class B_삼각형과세변 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
            int side1 = Integer.parseInt(stringTokenizer.nextToken());
            int side2 = Integer.parseInt(stringTokenizer.nextToken());
            int side3 = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(solution(side1, side2, side3));
        }
    }

    public static String solution(int side1, int side2, int side3) {
        if(side1 == 0 && side2 == 0 && side3 == 0) {
            return "";
        }

        int[] sides = {side1, side2, side3};
        Arrays.sort(sides);

        if(sides[2] >= sides[0] + sides[1]) {
            return "Invalid";
        }

        if(isEquilateral(side1, side2, side3)) {
            return "Equilateral";

        }else if(isIsosceles(side1, side2, side3)) {
            return "Isosceles";

        }else if(isScalene(side1, side2, side3)) {
            return "Scalene";

        }else {
            return "Invalid";
        }
    }

    // 정 삼각형
    public static boolean isEquilateral(int side1, int side2, int side3) {
        return side1 == side2 && side2 == side3 && side1 == side3;
    }

    // 이등변 삼각형
    public static boolean isIsosceles(int side1, int side2, int side3) {
        return side1 == side2 || side2 == side3 || side1 == side3;
    }

    // 세 변 다른 삼각형
    public static boolean isScalene(int side1, int side2, int side3) {
        return side1 != side2 && side2 != side3 && side1 != side3;
    }

}
