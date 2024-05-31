class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return true;
        int length = nums.length;
        boolean[] reachableArray = new boolean[length];
        reachableArray[length - 1] = true;
        for (int i = length - 2; i >= 0; i--) {
            int currentVal = nums[i];
            if (currentVal == 0) continue;
            // check if directly reachable
            if (i + nums[i] >= length)
                reachableArray[i] = true;
            if (!reachableArray[i]) {
                for (int j = 1; j <= currentVal; j++) {
                    int nextJump = i + j;
                    if (nextJump < length && reachableArray[nextJump]) {
                        reachableArray[i] = true;
                        break;
                    }
                }
            }
        }
        return reachableArray[0];
    }
}