class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] minCoinsCount = new int[amount + 1];
        minCoinsCount[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            // setting higher limit
            int minCount = amount + 1;
            for (int coin : coins) {
                if (coin > currentAmount) continue;
                minCount = Math.min(minCount, 1 + minCoinsCount[currentAmount - coin]);
            }
            minCoinsCount[currentAmount] = minCount;
        }
        return minCoinsCount[amount] == amount + 1 ? -1 : minCoinsCount[amount];
    }

}