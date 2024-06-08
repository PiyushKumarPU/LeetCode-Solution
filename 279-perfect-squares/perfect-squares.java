class Solution {
    int[] squareCount;
    public int numSquares(int n) {
        if (squareCount == null) {
            squareCount = new int[n + 1];
            Arrays.fill(squareCount, -1);
        }
        if (n == 0) return 0;
        if (squareCount[n] != -1) return squareCount[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, numSquares(n - i * i));
        }
        squareCount[n] = min + 1;
        return squareCount[n];
    }
}