class Solution {
    public int findMin(int[] nums) {
      if (nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];
        int start = 0, end = nums.length - 1, ans = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // cond1 mid > A[0] move right
            // cond2 mid < A[0] move left
            if (nums[mid] >= nums[0]) start = mid + 1;
            else {
                ans = nums[mid];
                end = mid - 1;
            }
        }
        return ans;  
    }
}