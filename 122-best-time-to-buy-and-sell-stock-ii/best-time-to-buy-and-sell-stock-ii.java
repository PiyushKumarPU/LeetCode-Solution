class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            int currentProfit = prices[i+1] - prices[i];
            totalProfit += (currentProfit > 0 ? currentProfit : 0);
        }
        return totalProfit;
    }
}