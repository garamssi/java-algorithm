package week9;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=leetcode-75
 * 1137. N-th Tribonacci Number
 */
public class A_NthTribonacciNumber {
    public static void main(String[] args) {
        System.out.println(tribonacci(5));
    }

    static Map<Integer, Integer> dp = new HashMap<>();
    public static int tribonacci(int n) {
        if(dp.containsKey(n)) {
            return dp.get(n);
        }
        if(n <= 1) {
            return n;
        }
        if(n == 2) {
            return 1;
        }

        dp.put(n, tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
        return dp.get(n);
    }
}
