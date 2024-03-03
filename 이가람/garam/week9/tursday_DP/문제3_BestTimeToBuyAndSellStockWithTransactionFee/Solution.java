package garam.week9.tursday_DP.문제3_BestTimeToBuyAndSellStockWithTransactionFee;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/?envType=study-plan-v2&envId=leetcode-75
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 1}, 2));
    }

    private static int maxProfit(int[] prices, int fee) {
            int buy = Integer.MIN_VALUE;
            int sell = 0;

            for (int price : prices) {
                buy = Math.max(buy, sell - price);
                sell = Math.max(sell, buy + price - fee);
            }

            return sell;
    }
}
