class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return 0;
        // calculate prefix sum array
        int[] pfSum = new int[nums.length];
        pfSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pfSum[i] = nums[i] + pfSum[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int leftSum = i > 0 ? pfSum[i - 1] : 0;
            int rightSum = i == nums.length - 1 ? 0 : pfSum[nums.length - 1] - pfSum[i];
            if (leftSum == rightSum) return i;
        }
        return -1;
    }
}