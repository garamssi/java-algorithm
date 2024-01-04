package garam.week1.문제3_BestTimeToBuyAndSellStock;

public class Solution {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{8, 1, 5, 3, 6, 4}));
	}

	public static int maxProfit(int[] prices) {

		int maxProfit = 0;
		int minPrice = prices[0];

		for(int price : prices) {
			minPrice = Math.min(minPrice, price);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}

		return maxProfit;
	}
}
