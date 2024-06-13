class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 1) return nums[0] == 1 ? 2 : 1;
        int length = nums.length;
        int[] result = new int[length];
        for (int current : nums) {
            if (current <= 0 || current > length) continue;
            result[current - 1] = current;
        }
        for (int i = 0; i < length; i++) {
            int present = result[i];
            if (present != (i + 1)) return i + 1;
        }
        return length + 1;
    }
}