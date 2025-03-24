class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return result;
        // find first occurance
        int start = 0, end = nums.length - 1;
        int first = -1, second = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) first = mid;
                end = mid - 1;
            } else start = mid + 1;
        }

        // first == -1 it means element not found
        if (first == -1)
            return result;
        // find second occurance
        start = first;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) second = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        result[0] = first;
        result[1] = second;
        return result;
    }
}