class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) return 0;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        // control reaches here means element is not available in array
        if (target < nums[0]) return 0;
        else if (target > nums[nums.length - 1]) return nums.length;
        else if (nums.length == 2) return 1;
        else {
            // find appropriate place to insert it
            start = 0;
            end = nums.length - 1;
            int currentAns = 0;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] > target && nums[mid - 1] < target) currentAns = mid;
                if (nums[mid] > target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            return currentAns;
        }
    }
}