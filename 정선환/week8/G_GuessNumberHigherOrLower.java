package week8;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/?envType=study-plan-v2&envId=leetcode-75
 * 374. Guess Number Higher or Lower
 */
public class G_GuessNumberHigherOrLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(guessNumber(n));
    }

    public static int guessNumber(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int minRange = 1;
        int maxRange = n;
        while(true) {
            int num = minRange + (maxRange - minRange) / 2;
            int result = guess(num);

            if(result == -1) {
                maxRange = num - 1;

            }else if(result == 1) {
                minRange = num + 1;

            }else {
                return num;
            }
        }

    }

    public static int guess(int num) {

        return 0;
    }
}
