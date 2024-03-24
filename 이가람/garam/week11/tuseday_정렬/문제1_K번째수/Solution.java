package garam.week11.tuseday_정렬.문제1_K번째수;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});

    }

    public static int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int[] values = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(values);
            answer.add(values[commands[i][2] - 1]);
        }

        return answer.stream().mapToInt(i -> i).toArray();

    }
}
