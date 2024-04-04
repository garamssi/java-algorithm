package week14;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * 정수 삼각형
 */
public class B_정수삼각형 {

    public static void main(String[] args) {
        int[][] triangle = {
            {7},            //           (0,0)
            {3, 8},         //         (1,0)(1,1)
            {8, 1, 0},      //       (2,0)(2,1)(2,2)
            {2, 7, 4, 4},   //     (3,0)(3,1)(3,2)(3,3)
            {4, 5, 2, 6, 5} //   (4,0)(4,1)(4,2)(4,3)(4,4)
        };
        System.out.println(solution(triangle)); // 30
    }

    public static int solution(int[][] triangle) {
        backtrack(triangle, 0, 0, new ArrayList<>());
        return maxSum;
    }

    static int maxSum = Integer.MIN_VALUE;
    public static void backtrack(int[][] triangle, int i , int j, List<Integer> sumList) {

        if(sumList.size() == triangle.length) {
            int sum = sumList.stream().mapToInt(Integer::intValue).sum();
            maxSum = Math.max(maxSum, sum);
            return ;
        }


        for (int i1 = i; i1 < triangle.length; i1++) {
            for(int j1 = j; j1 < triangle[i1].length; j1++) {
                int num = triangle[i1][j1];
                sumList.add(num);
                backtrack(triangle, i1, j1, sumList);
            }
        }




    }
















//    public static int solution(int[][] triangle) {
//        int answer = 0;
//
//        for (int i = 0; i < triangle.length; i++) {
//            for (int j = 0; j < triangle[i].length; j++) {
//                if (i == 0) {
//                    continue;
//                }
//
//                    if (j == 0) {
//                        triangle[i][j] += triangle[i - 1][j];
//                    } else if (j == triangle[i].length - 1) {
//                        triangle[i][j] += triangle[i - 1][j - 1];
//                    } else {
//                        triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
//                    }
//
//                    if (i == triangle.length - 1) {
//                        answer = Math.max(answer, triangle[i][j]);
//                    }
//                }
//        }
//
//        return answer;
//    }

}
