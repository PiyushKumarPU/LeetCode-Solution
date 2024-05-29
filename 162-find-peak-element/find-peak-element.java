class Solution {
    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            boolean isPeak = ((i > 0 && nums[i] > nums[i-1]) || i == 0) &&
            ((i < nums.length - 1 && nums[i] > nums[i+1]) || i == nums.length -1);
            if(isPeak) return i;
        }
        return -1;
    }
}