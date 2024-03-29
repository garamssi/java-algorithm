package week12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * 소수 찾기
 */
public class H_소수찾기 {

    private static Set<Integer> found = new HashSet<>(); // 중복된 조합을 방지하기 위해 사용

    public static void main(String[] args) {
//        String numbers = "011";  // 1 7 3 17 13 71 73 31 37 173 137 713 731 317 371
//        String numbers = "17";  // 1 17 173 13 137 7 71 713 73 731 3 31 317 37 371
        String numbers = "011";

        System.out.println(solution(numbers));
    }

    static int count = 0;
    public static int solution(String numbers) {
        char[] numberArray = numbers.toCharArray();
        boolean[] visited = new boolean[numberArray.length];
        dfs(numberArray, new StringBuilder(), visited);
        return found.size();
    }

    private static void dfs(char[] numberArray, StringBuilder sb, boolean[] visited) {
        if (sb.length() > 0) {
            int number = Integer.parseInt(sb.toString());
            if(isPrime(number)) {
                count++;
                found.add(number);
            }
        }

        for (int i = 0; i < numberArray.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(numberArray[i]);

                dfs(numberArray, sb, visited);

                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    // 소수 찾기 (에라토스테네스의 채)
    private static boolean isPrime(int number) {
        if(number == 0) {
            return false;
        }
        boolean[] isPrime = new boolean[number + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i * i < isPrime.length; i++) {
            if(isPrime[i]) {
                for(int j = i + i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime[number];
    }

}
