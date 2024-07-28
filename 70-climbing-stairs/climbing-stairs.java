class Solution {
    int[] stairCounts;
    public int climbStairs(int n) {
        if(n == 1) return 1;
        stairCounts = new int[n+1];
        Arrays.fill(stairCounts,-1);
        stairCounts[0] = 0;
        stairCounts[1] = 1;
        stairCounts[2] = 2;
        return calculateStairCount(n);
    }

    private int calculateStairCount(int n){
        if(n < 0) return 0;
        if(stairCounts[n] != -1) return stairCounts[n];
        stairCounts[n] = calculateStairCount(n-1) + calculateStairCount(n-2);
        return stairCounts[n];
    }

}