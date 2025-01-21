class Solution {
    public int maxProfit(int[] prices) {
     int[] rightMax = new int[prices.length];
        rightMax[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], prices[i]);
        }
        int maxProfit = rightMax[0] - prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, rightMax[i] - prices[i]);
        }
        return maxProfit; 
    }
}