class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 1) return true;

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                isDecreasing = false;
            }
            if (nums[i] < nums[i - 1]) {
                isIncreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }
}