class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxCount =0;
        for(int num : nums){
            if(num == 1) {
                count++;
                if(count > maxCount) maxCount = count;
            }else{
                count = 0;
            }
        }
        return maxCount;
    }
}