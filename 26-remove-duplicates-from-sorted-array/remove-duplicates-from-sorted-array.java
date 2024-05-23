class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0, count = 0;
        for(int i = 0; i < nums.length;i++){
            if(index > 0 && nums[i] == nums[index -1]) continue;
            nums[index++] = nums[i];
            count++;            
        }
        return count;
    }
}