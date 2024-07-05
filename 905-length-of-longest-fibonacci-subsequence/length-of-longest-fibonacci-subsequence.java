class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length, maxLength = 0;
        // for index 0 and 1 there would not be any fibonacci so wil keep it as 0
        // creating a dp array to hold longest fibonacci crated using index i and j
        int[][] dp = new int[n][n];

        for (int i = 2; i < n; i++) {
            // check if there is any pair before i whose sum would be equal to A[i]
            int start = 0, end = i - 1;
            while (start < end) {
                int currentTotal = A[start] + A[end];
                if (currentTotal > A[i])
                    end--;
                else if (currentTotal < A[i]) start++;
                else {
                    dp[end][i] = dp[start][end] + 1;
                    maxLength = Math.max(maxLength, dp[end][i]);
                    start++;
                    end--;
                }
            }
        }
        // if maxLength is greater than 0 it means there was a fibonacci so we will add 2 to accommodate 2 index which
        // we didn't add
        return maxLength > 0 ? maxLength + 2 : 0;
    }
}