class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int start = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i < nums.length) {
                count++;
                nums[start++] = nums[i];
            }
        }
        return count;
    }
}