class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int k = i + 1;
                while (k < nums.length && nums[k] == 0) k++;
                if(k < nums.length){
                    nums[i] = nums[k];
                    nums[k] = 0;
                }
            }
        }
    }
}