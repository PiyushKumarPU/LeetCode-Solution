class Solution {
    public int findPeakElement(int[] nums) {
       if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // check if mid is greater than both neighbours
            if ((mid - 1 < 0 || nums[mid] > nums[mid - 1]) &&
                    (mid + 1 >= nums.length || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid - 1 < 0 || nums[mid] > nums[mid - 1]) start = mid + 1;
            else end = mid - 1;
        }
        return -1; 
    }
}