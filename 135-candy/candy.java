class Solution {
    public int candy(int[] ratings) {
        // idea first assign one candy to each
        // then start looking right, if current has more rating than right one then it should have more candy than right
        // then start looking left, if current has more rating then it should get at least one more candy than left
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);
        // Check from left to right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }

        // Check from right to left
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
        }
        int candyCount = 0;
        for (int count : result) candyCount += count;
        return candyCount;
    }
}