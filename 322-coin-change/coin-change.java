class Solution {
    int[] coinCounts;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins == null || coins.length == 0) return 0;
        coinCounts = new int[amount + 1];
        Arrays.fill(coinCounts, -2);
        coinCounts[0] = 0;
        return calculateCoinCounts(coins, amount);
    }

    private int calculateCoinCounts(int[] coins, int amount) {
        if (amount <= 0) return 0;
        if (coinCounts[amount] != -2) return coinCounts[amount];

        Integer count = null;
        for (int coin : coins) {
            if (coin > amount) continue;
            int coinCount = calculateCoinCounts(coins, amount - coin);
            if (coinCount < 0) continue;
            coinCount++;
            count = count == null ? coinCount : Math.min(count, coinCount);
        }
        coinCounts[amount] = count == null ? -1 : count;
        return coinCounts[amount];
    }
}