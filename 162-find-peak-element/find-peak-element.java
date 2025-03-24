class Solution {
    public int findPeakElement(int[] nums) {
       if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // Compare mid with its next neighbor
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}