class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0, maxPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }

        return maxProfit;
    }
}