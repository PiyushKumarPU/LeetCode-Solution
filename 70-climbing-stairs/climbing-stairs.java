class Solution {
    int[] waysCount;
    public int climbStairs(int n) {
        waysCount = new int[n+1];
        Arrays.fill(waysCount,-1);
        return countWays(n);
    }

    private int countWays(int n){
        if(n <= 2) return n;
        if(waysCount[n] != -1) return waysCount[n];
        waysCount[n] = countWays(n-1) + countWays(n-2);
        return waysCount[n];
    }
}