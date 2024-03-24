package garam.week11.tuseday_정렬.문제2_가장큰수;

public class Solution {

    public static void main(String[] args) {

    }

    public String solution(int[] numbers) {

        int answer = Integer.MIN_VALUE;

        for (int number : numbers) {
            String value = dfs(number, numbers, new StringBuilder());
            answer = Math.max(answer, Integer.parseInt(value));
        }

        return String.valueOf(answer);
    }

    public static String dfs(int index, int[] numbers, StringBuilder str) {
        return "";
    }
}
