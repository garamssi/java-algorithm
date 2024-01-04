class Solution {

    // 시간복잡도: O(n)
    // 우측으로 이동하면서 minPrice를 업데이트
    // minPrice를 현재 시점 저점으로 생각하고, maxProfit값 계산.
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice); 
        }

        return maxProfit;
    }
}