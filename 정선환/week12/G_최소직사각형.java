package week12;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * 최소 직사각형
 */
public class G_최소직사각형 {

    public static void main(String[] args) {
        int[][] sizes = {
                {60, 50}, // 60 50
                {30, 70}, // 30 70
                {60, 30}, // 60 30
                {80, 40}  // 80 40
        };

//        int[][] sizes = {
//                {10, 7},    // 10 7
//                {12, 3},    // 12 3
//                {8, 15},    // 15 8
//                {14, 7},    // 14 7
//                {5, 15}     // 15 5
//        };

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int width = 0;
        int height = 0;

        for (int[] size: sizes) {
            int currWidth = Math.max(size[0], size[1]);
            int currHeight = Math.min(size[0], size[1]);

            width = Math.max(currWidth, width);
            height = Math.max(currHeight, height);
        }

        return width * height;
    }
}
