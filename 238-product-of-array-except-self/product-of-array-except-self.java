class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return null;
        int size = nums.length;
        if (size == 1) return new int[]{0};
        int[] result = new int[size];
        int temp = 1;
        for (int i = 0; i < size; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = size - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}