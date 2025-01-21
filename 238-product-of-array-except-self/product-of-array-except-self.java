class Solution {
    public int[] productExceptSelf(int[] nums) {
       int len = nums.length;
        int[] leftMultipliers = new int[len];
        int[] rightMultipliers = new int[len];

        leftMultipliers[0] = 1;
        rightMultipliers[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            leftMultipliers[i] = leftMultipliers[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMultipliers[i] = rightMultipliers[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = leftMultipliers[i] * rightMultipliers[i];
        }
        return nums; 
    }
}