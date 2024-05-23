class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] result = new int[length];
        Arrays.fill(result, 1);
        // check from left to right for higher rank
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) result[i] = result[i - 1] + 1;
        }
        // check from right to left if left is greater than right
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                result[i] = (Math.max(result[i], result[i + 1] + 1));
        }
        int total = 0;
        for (int i : result) total += i;
        return total;
    }
}