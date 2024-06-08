class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int[] stairCounts = new int[n + 1];
        stairCounts[1] = 1;
        stairCounts[2] = 2;
        for (int i = 3; i <= n; i++) {
            stairCounts[i] = stairCounts[i - 1] + stairCounts[i - 2];
        }
        return stairCounts[n]; 
    }
}