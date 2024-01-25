package week1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Best Time to Buy and Sell Stock
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 */
public class C_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String numsString = sc.nextLine();
        int[] nums = Arrays.stream(numsString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        // 가장 작은 매수금액과 인덱스 찾기
        int minPrice = prices[0];
        int minPriceIndex = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++) {
            if(minPrice > prices[i]) {
                minPrice = prices[i];
                minPriceIndex = i;
            }
        }

        // 가장 작은 매수금액 이후 금액의 차이 구하기
        int maxProfit = 0;
        for(int i = minPriceIndex + 1; i < n; i++) {
            int profit = prices[i] - minPrice;
            if(profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
