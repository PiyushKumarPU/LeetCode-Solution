class Solution {
    int[] breakValues;

    public int integerBreak(int n) {
        // Create a memoization array initialized to -1
        breakValues = new int[n + 1];
        Arrays.fill(breakValues, -1);
        return integerBreakHelper(n);
    }

    private int integerBreakHelper(int n) {
        // Base cases
        if (n <= 1) return 0;
        else if (n <= 3) return n - 1;
        else if (breakValues[n] != -1) return breakValues[n];

        int maxProduct = 0;
        for (int i = 1; i < n; i++) {
            int productWithoutFurtherCut = i * (n - i);
            int productWithFurtherCut = i * integerBreakHelper(n - i);
            int currentProduct = Math.max(productWithoutFurtherCut, productWithFurtherCut);
            maxProduct = Math.max(maxProduct, currentProduct);
        }
        breakValues[n] = maxProduct;
        return maxProduct;
    }
}