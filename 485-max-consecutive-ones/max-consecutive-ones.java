class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, currentMax = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) currentMax ++;
            else{
                max = Math.max(max,currentMax);
                currentMax = 0;
            }
        }
        max = Math.max(max,currentMax);
        return max;
    }
}