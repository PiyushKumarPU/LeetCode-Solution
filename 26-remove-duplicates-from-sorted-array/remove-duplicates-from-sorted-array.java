class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int count =1, start = 0, current = 0;
        while(start < nums.length){
            if(nums[start] == nums[current]) start++;
            else{
                nums[++current]= nums[start];
                count++;
            }
        }
        return count;
    }
}