class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE, maxPrice = Integer.MIN_VALUE;
        for(int price: prices) {
            maxPrice = Math.max(maxPrice, price);
            maxProfit = Math.max(maxProfit, maxPrice - minPrice);
            int temp = minPrice;
            minPrice = Math.min(minPrice, price);
            if(minPrice < temp) {
                maxPrice = Integer.MIN_VALUE;
            }
        }
        return maxProfit;      
    }
}