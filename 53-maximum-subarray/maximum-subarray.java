class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = 0, totalMax = Integer.MIN_VALUE;
        for (int num : nums) {
            currentMax += num;
            totalMax = Math.max(currentMax, totalMax);
            if (currentMax < 0) currentMax = 0;
        }
        return totalMax;
    }
}