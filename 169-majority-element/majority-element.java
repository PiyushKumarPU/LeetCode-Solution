class Solution {
    public int majorityElement(int[] nums) {
     HashMap<Integer,Integer> countValMap = new HashMap<>();
     for(int i = 0; i < nums.length; i++){
        int preCount = countValMap.getOrDefault(nums[i], 0);
        preCount += 1;
        if(preCount > nums.length/2) return nums[i];
        countValMap.put(nums[i], preCount);
     }   
     return -1;
    }
}