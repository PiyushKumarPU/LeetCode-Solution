class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        int length = nums.length;
        int[] minStep = new int[length];
        Arrays.fill(minStep, Integer.MAX_VALUE);
        minStep[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            int currentVal = nums[i];
            if (currentVal == 0) continue;
            // check if directly reachable
            if (i + currentVal >= (length - 1))
                minStep[i] = 1;

            for (int j = 1; j <= currentVal; j++) {
                int nextJump = i + j;
                int minJump = nextJump < length ? minStep[nextJump] : Integer.MAX_VALUE;
                if(minJump != Integer.MAX_VALUE)
                    minStep[i] = Math.min(minStep[i], minJump + 1);
            }
        }
        return minStep[0];
    }
}