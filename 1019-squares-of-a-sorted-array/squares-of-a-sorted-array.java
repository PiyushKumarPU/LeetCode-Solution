class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int start = 0, end = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (Math.abs(nums[start]) >= Math.abs(nums[end])) {
                ans[i] = nums[start] * nums[start];
                start++;
            } else {
                ans[i] = nums[end] * nums[end];
                end--;
            }
        }
        return ans;
    }
}